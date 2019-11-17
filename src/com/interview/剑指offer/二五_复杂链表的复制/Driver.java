package com.interview.剑指offer.二五_复杂链表的复制;

//测试用例{1,2,3,4,5,3,5,#,2,#}
public class Driver {

	public static void main(String[] args) {
		Solution2 s = new Solution2();
		RandomListNode node1 = new RandomListNode(1);
		RandomListNode node2 = new RandomListNode(2);
		RandomListNode node3 = new RandomListNode(3);
		RandomListNode node4 = new RandomListNode(4);
		RandomListNode node5 = new RandomListNode(5);
		
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		
		node1.random=node3;
		node2.random=node5;
		node4.random=node2;
		RandomListNode clone = s.Clone(node1);
		System.out.println(clone==node1);
		System.out.println(clone.equals(node1));
	}

}
