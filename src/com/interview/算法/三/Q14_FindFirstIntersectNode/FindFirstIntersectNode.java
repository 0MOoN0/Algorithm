package com.interview.算法.三.Q14_FindFirstIntersectNode;

import java.util.Optional;

import com.interview.算法.common.Node;

/**
 * 两个单链表相交的一系列问题
 * 1. 链表是否有环，环的入口是哪里
 * 2. 链表是否相交，带环相交有多少种情况
 * 一个有环链表与一个无环链表无法相交
 * 两个有环链表相交，则交点后的节点都相同
 * 两个有环链表相交有三种形态
 * @author Peter
 *
 */
public class FindFirstIntersectNode {
	
	// 找到链表相交的第一个节点
	public static Node findFirstIntersectNode(Node head1, Node head2) {
		if(head1 == null || head2 == null) {
			return null;
		}
		Node loopNode1 = getLoopNode(head1);
		Node loopNode2 = getLoopNode(head2);
		// 是否有环
		if(loopNode1 != null && loopNode2 != null) {
			return bothLoop(head1, loopNode1, head2, loopNode2);
		}else if(loopNode1 == null && loopNode2 ==null) {
			return noLoop(head1, head2);
		}
		// 其他情况无交点
		return null;
	}
	
	// 两个有环链表相交
	public static Node bothLoop(Node head1, Node loppNode1, Node head2, Node loopNode2) {
		// 第一种情况
		if(loppNode1 == loopNode2) {	// 两个链表相交，并在同一个环内，且环入口相等
			// 解决方案：类似无环链表相交
			Node cur1 = head1;
			Node cur2 = head2;
			int n=0;
			while(cur1 != loppNode1) {
				n++;
				cur1 = cur1.next;
			}
			while(cur2 != loopNode2) {
				n--;
				cur2 = cur2.next;
			}
			// 判断两条链表的长度
			cur1 = n > 0 ? head1 : head2;	// 较长的链表
			cur2 = cur1 == head1 ? head2 : head1;
			n = Math.abs(n);
			while(n != 0) {
				n--;
				cur1 = cur1.next;
			}
			while(cur1 != cur2) {
				cur1 = cur1.next;
				cur2 = cur2.next;
			}
			return cur1;
		}else {
			// 情况1：两个有环链表不相交
			// 情况2：两个有环链表相交，且环入口不相等
			// 情况1，两个入口不在一个环上，无法从loop1到loop2
			Node cur1 = loppNode1.next;
			while(cur1 != loppNode1) {
				if(cur1 == loopNode2) return cur1;	//相交，且交点有两个
				cur1 = cur1.next;
			}
			return null;	// 不相交
		}
	}

	// 判断一个链表是否有环，如果有环则返回入口节点
	public static Node getLoopNode(Node head) {
		// 不可能形成环
		if(head == null || head.next == null || head.next.next == null) {
			return null;
		}
		Node fastNode = head.next.next;
		Node slowNode = head.next;
		while(fastNode != slowNode) {
			fastNode = fastNode.next.next;
			slowNode = slowNode.next;
			// 没有闭环
			if(fastNode == null || fastNode.next == null) {
				return null;
			}
		}
		fastNode = head;
		while(fastNode != slowNode) {
			fastNode = fastNode.next;
			slowNode = slowNode.next;
		}
		return fastNode;
	}
	
	// 无环链表的共同节点，无环链表相交，可能呈Y字或V字形，如果相交的话，他们的最后一个节点一定是相同的
	public static Node noLoop(Node head1, Node head2) {
		Node cur1 = head1;
		Node cur2 = head2;
		int n = 0;
		// 计算head1的长度，并指向最后一个节点
		while(cur1.next != null) {
			n++;
			cur1 = cur1.next;
		}
		// 计算head2的长度，并指向最后一个节点
		while(cur2.next != null) {
			n--;
			cur2 = cur2.next;
		}
		// 如果最后一个节点不相等，则说明两条链表不相交
		if(cur2 != cur1) {
			return null;
		}
		// cur1为链表较长一端，cur2为较短一端
		cur1 = n > 0 ? head1 : head2;
		cur2 = cur1 == head1 ? head2 : head1;
		// 计算两条链表的长度差，并让较长的链表走n步
		n = Math.abs(n);
		while(n != 0) {
			cur1 = cur1.next;
			n--;
		}
		// 此时两个指针指向的链表剩余长度相等
		while(cur1 != cur2) {
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		return cur1;
	}
	
    public static Node FindFirstCommonNode2(Node pHead1, Node pHead2) {
    	Node l1 = pHead1, l2 = pHead2;
        boolean flag1 = false, flag2 = false;
        while (l1 != l2) {
            if (l1 == null) {
                if (flag1)
                    return null;
                flag1 = true;
                l1 = pHead2;
            }else
                l1 = l1.next;

            if (l2 == null){
                if (flag2)
                    return null;
                flag2 = true;
                l2 = pHead1;
            }else
                l2 = l2.next;


//            l1 = (l1 == null) ? pHead2 : l1.next;
//            l2 = (l2 == null) ? pHead1 : l2.next;
        }
        return l1;
    }
	
	
	public static void main(String[] args) {
		// 1->2->3->4->5->6->7->4...
		Node head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(6);
		head1.next.next.next.next.next.next = new Node(7);
		head1.next.next.next.next.next.next = head1.next.next.next; // 7->4
		
//		Optional.ofNullable(getLoopNode(head1)).ifPresent(h -> System.out.println(h.value));
		
		// 0->9->8->6->null
		Node head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = new Node(6);
//		Optional.ofNullable(getLoopNode(head2)).ifPresent(h -> System.out.println(h.value));
		
		//==========无环链表相交测试==========
		Node head3 = new Node(0);
		head3.next = new Node(9);
		head3.next.next = new Node(8);
		head3.next.next.next = new Node(6);	// 0->9->8->6->null
		Node head4 = new Node(10);
		head4.next = new Node(9);
		head4.next.next = head3.next.next;
		head4.next.next.next = head3.next.next.next;	// 10->9(非同地址)->8->6->null
//		Optional.ofNullable(findFirstIntersectNode(head3, head4)).ifPresent(h -> System.out.println(h.value));
//		Optional.ofNullable(FindFirstCommonNode2(head3, head4)).ifPresent(h->System.out.println(h));
		
		//=========无环链表不相交测试=========
		Node head5 = new Node(0);
		head5.next = new Node(9);
		head5.next.next = new Node(8);
		head5.next.next.next = new Node(6);	// 0->9->8->6->null		
		Node head6 = new Node(10);
		head6.next = new Node(11);
		head6.next.next = new Node(12);
		head6.next.next.next = new Node(13);	// 0->9->8->6->null	
		Node result = findFirstIntersectNode(head5, head6);
//		System.out.println(result);
		
		// 有环不相交
		Node head7 = new Node(0);
		head7.next = new Node(9);
		head7.next.next = new Node(8);
		head7.next.next.next = new Node(6);	// 0->9->8->6->9
		head7.next.next.next.next = head7.next;
		Node head8 = new Node(10);
		head8.next = new Node(19);
		head8.next.next = new Node(18);
		head8.next.next.next = new Node(16);	// 10->19->18->16->19
		head8.next.next.next.next = head8.next;
		Node result2 = findFirstIntersectNode(head7, head8);
		System.out.println(result2);
		
		
		// 有环相交，且交点相同
		// 0->9->8->6(交点)->14->15->16->6(交点)
		Node head9 = new Node(10);
		head9.next = new Node(9);
		head9.next.next = new Node(8);
		head9.next.next.next = new Node(6);	
		
		// 11->12->13->6(交点)->14->15->16->6(交点)
		Node head10 = new Node(11);
		head10.next = new Node(12);
		head10.next.next = new Node(13);	
		head10.next.next.next = head9.next.next.next;	
		head10.next.next.next.next = new Node(14);
		head10.next.next.next.next.next = new Node(15);
		head10.next.next.next.next.next.next = new Node(16);
		head10.next.next.next.next.next.next.next = head10.next.next.next;
//		System.out.println(findFirstIntersectNode(head10, head9));
		
		// 有环相交，交点不同
		// 11->12->13(交点环入口)->14->15->16->17->13(交点环入口)
		Node head11 = new Node(11);
		head11.next = new Node(12);
		head11.next.next = new Node(13);	// 环入口
		head11.next.next.next = new Node(14);
		head11.next.next.next.next = new Node(15);
		head11.next.next.next.next.next = new Node(16);
		head11.next.next.next.next.next.next = new Node(17);
		head11.next.next.next.next.next.next.next = head11.next.next;
		// 链表2： 18->19-15>(交点环入口)->16->17->13->14->15(交点环入口)
		Node head12 = new Node(18);
		head12.next = new Node(19);
		head12.next.next = head11.next.next.next.next;
//		System.out.println(findFirstIntersectNode(head12,head11));
		
	}

}
