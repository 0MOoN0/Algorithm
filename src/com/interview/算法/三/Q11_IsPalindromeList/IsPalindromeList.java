package com.interview.算法.三.Q11_IsPalindromeList;

import java.util.Stack;

/**
 * 判断链表是否为回文链表 进阶： 如果链表长度为N，时间复杂度达到O(N)，额外空间复杂度达到O(1)。
 * 
 * 方法一：使用一个大小为N的栈 
 * 方法二：快慢指针+大小为N/2的栈
 * 方法三：快慢指针+反转链表	时间复杂度达到O(N)，额外空间复杂度达到O(1)
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
		// 判断是否回文
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
		// 如果链表为空或者只有一个元素，返回true
		if (p == null || p.next == null) {
			return true;
		}
		// 快慢指针
		Node fasterP = p;
		Node cur = p;
		while(fasterP.next != null && fasterP.next.next != null) {
			cur = cur.next;
			fasterP = fasterP.next.next;
		}
		// 收集节点
		Stack<Node> s = new Stack<Node>();
//		cur = cur.next; 
		while(cur!=null){
			s.push(cur);
			cur = cur.next;
		}
		// 比较节点，判断是否回文
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
		// =================方法二测试=======================
		System.out.println(isPalindromeList2(node1));
		System.out.println(isPalindromeList2(node2));
	}

}
