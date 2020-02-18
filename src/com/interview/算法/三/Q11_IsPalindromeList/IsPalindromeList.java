package com.interview.�㷨.��.Q11_IsPalindromeList;

import java.util.Stack;

/**
 * �ж������Ƿ�Ϊ�������� ���ף� ���������ΪN��ʱ�临�ӶȴﵽO(N)������ռ临�ӶȴﵽO(1)��
 * 
 * ����һ��ʹ��һ����СΪN��ջ 
 * ������������ָ��+��СΪN/2��ջ
 * ������������ָ��+��ת����	ʱ�临�ӶȴﵽO(N)������ռ临�ӶȴﵽO(1)
 * 
 * @author Peter
 *
 */
public class IsPalindromeList {

	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}

	public static boolean isPalindromeList1(Node p) {
		Stack<Node> s = new Stack<Node>();
		Node q = p;
		while (q != null) {
			s.push(q);
			q = q.next;
		}
		// �ж��Ƿ����
		while (!s.isEmpty()) {
			if (s.pop().value == p.value) {
				p = p.next;
				continue;
			}
			return false;
		}
		return true;
	}

	public static boolean isPalindromeList2(Node p) {
		// �������Ϊ�ջ���ֻ��һ��Ԫ�أ�����true
		if (p == null || p.next == null) {
			return true;
		}
		// ����ָ��
		Node fasterP = p;
		Node cur = p;
		while(fasterP.next != null && fasterP.next.next != null) {
			cur = cur.next;
			fasterP = fasterP.next.next;
		}
		// �ռ��ڵ�
		Stack<Node> s = new Stack<Node>();
//		cur = cur.next; 
		while(cur!=null){
			s.push(cur);
			cur = cur.next;
		}
		// �ȽϽڵ㣬�ж��Ƿ����
		while(!s.isEmpty()) {
			if(s.pop().value != p.value) {
				return false;
			}
			p = p.next;
		}
		return true;
	}
	
	public static boolean isPalindromeList3(Node p) {
		
		
		return false;
	}
	

	public static void main(String[] args) {
		Node node1 = new Node(1);
		node1.next = new Node(2);
		node1.next.next = new Node(5);
		node1.next.next.next = new Node(2);
		node1.next.next.next.next = new Node(1);
		Node node2 = new Node(1);
		node2.next = new Node(2);
		node2.next.next = new Node(2);
//		node2.next.next.next = new Node(1);
		System.out.println(isPalindromeList1(node1));
		System.out.println(isPalindromeList1(node2));
		// =================����������=======================
		System.out.println(isPalindromeList2(node1));
		System.out.println(isPalindromeList2(node2));
	}

}
