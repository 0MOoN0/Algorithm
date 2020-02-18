package com.interview.�㷨.��.Q7_ReverseList;

import com.interview.�㷨.��.Q10_PrintCommonPart.PrintCommonPart.Node;

/**
 * ��ת����
 * @author Peter
 *
 */
public class ReverseList {
	
	// ������ڵ�
	public static class Node {
		public int value;
		public Node next;
		public Node(int data) {
			this.value = data;
		}
	}	
	
	// ��ת������
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

	
	// ��ӡ����
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
		// ��תǰ
		printLinkedList(node1);
		// ��ת����
		Node reverseList = reverseList(node1);
		// ��ת��
		printLinkedList(reverseList);
	}

}
