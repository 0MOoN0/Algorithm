package com.interview.算法.三.Q7_ReverseList;

import com.interview.算法.三.Q10_PrintCommonPart.PrintCommonPart.Node;

/**
 * 反转链表
 * @author Peter
 *
 */
public class ReverseList {
	
	// 单链表节点
	public static class Node {
		public int value;
		public Node next;
		public Node(int data) {
			this.value = data;
		}
	}	
	
	// 反转单链表
	public static Node reverseList(Node p) {
		Node p2 = null;
		Node p0 = null;
		while(p!=null) {
			p2 = p.next;
			p.next = p0;
			p0 = p;
			p = p2;
		}
		
		return p0;
	}

	
	// 打印链表
	public static void printLinkedList(Node p) {
		while(p!=null) {
			System.out.print(p.value+" ");
			p = p.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Node node1 = new Node(1);
		node1.next = new Node(2);
		node1.next.next = new Node(5);
		node1.next.next.next = new Node(2);
		// 反转前
		printLinkedList(node1);
		// 反转链表
		Node reverseList = reverseList(node1);
		// 反转后
		printLinkedList(reverseList);
	}

}
