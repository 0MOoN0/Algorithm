package com.interview.算法.三.Q12_SmallerEqualBigger;

import com.interview.算法.common.Node;
import com.interview.算法.utils.Utils;

/**
 * 将单向链表按某值划分成左边小、中间相等、右边大的形式
 * 将链表划分为小于K，等于K，大于K三部分
 * @author Peter
 *
 */
public class SmallerEqualBigger {
	
	public static Node smallerEqualBigger(Node p, int K) {
		Node cur = p;
		int size = 0;
		// 计算链表长度
		while(cur != null) {
			size++;
			cur = cur.next;
		}
		Node[] nodes = new Node[size];
		cur = p;
		// 将链表转为数组
		for(int i=0; i<nodes.length; i++) {
			nodes[i] = cur;
			cur = cur.next;
		}
		int lesA=-1,curA = 0, bigA=size;	// 小于域，等于域，大于域
		// 链表节点分派
		while(curA < bigA) {
			// 如果当前数小于K，则当前数与小于域的前一个数进行交换，当前指针++
			if(nodes[curA].value < K) {
				swap(nodes, ++lesA, curA++);
			}else if(nodes[curA].value == K) {	// 如果当前数等于K，则比较下一个数
				curA++;
			}else {	// 如果当前数大于K， 则将当前数与大于域的前一个进行交换
				swap(nodes, --bigA, curA);
			}
		}
		// 新生成链表
		for(int i=1; i<nodes.length; i++) {
			nodes[i-1].next = nodes[i];
		}
		// 尾指针处理
		nodes[size-1].next = null;
		return nodes[0];
	}
	
	public static void swap(Node[] nodes, int A, int B) {
		Node temp = nodes[A];
		nodes[A] = nodes[B];
		nodes[B] = temp;
	}
	
	public static void main(String[] args) {
		Node head1 = new Node(7);
		head1.next = new Node(9);
		head1.next.next = new Node(1);
		head1.next.next.next = new Node(8);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(2);
		head1.next.next.next.next.next.next = new Node(5);
		Utils.printLinkedList(head1);
		Node result1 = smallerEqualBigger(head1, 6);
		Utils.printLinkedList(result1);
		
	}

}
