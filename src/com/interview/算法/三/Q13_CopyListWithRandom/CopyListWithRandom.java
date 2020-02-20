package com.interview.算法.三.Q13_CopyListWithRandom;

import java.util.HashMap;
import java.util.Map;

import com.interview.算法.common.Node;

/**
 * 复制含有随机指针节点的链表
 * 1. 哈希表
 * @author Peter
 *
 */
public class CopyListWithRandom {
	
	public static class Node {
		public int value;
		public Node next;
		public Node rand;

		public Node(int data) {
			this.value = data;
		}
	}
	
	// 哈希表
	public static Node copyListWithRand1(Node head) {
		Map<Node, Node> nodeMap = new HashMap<Node,Node>();
		Node cur = head;
		// 将链表以节点-复制节点的方式映射到HashMap中
		while(cur != null) {
			nodeMap.put(cur, new Node(cur.value));
			cur = cur.next;
		}
		// 回归指针
		cur = head;
		// 复制链表
		while(cur != null) {
			nodeMap.get(cur).next = nodeMap.get(cur.next);
			nodeMap.get(cur).rand = nodeMap.get(cur.rand);
			cur = cur.next;
		}
		return nodeMap.get(head);
	}
	
	// 复制单链，复制rand域，分离链表(不需要其他特殊的数据结构支持)
	public static Node copyListWithRand2(Node head) {
		if(head == null) {
			return null;
		}
		// 复制单链
		Node cur = head;
		while(cur != null) {
			Node nNode = new Node(cur.value);
			nNode.next = cur.next;
			cur.next = nNode;
			cur = cur.next.next;
		}
		// 复制rand域
		cur = head;
		while(cur != null) {
			cur.next.rand = cur.rand == null ? null :cur.rand.next;
			cur = cur.next.next;
		}
		// 分离链表
		cur = head;
		Node res = head.next;
		Node next = cur.next;
		while(cur != null) {
			cur.next = cur.next.next;
			next.next = next.next == null ? null : next.next.next;
			cur = cur.next;
			next = next.next;
		}
		return res;
	}
	
	
	public static void printRandLinkedList(Node head) {
		Node cur = head;
		System.out.print("order: ");
		while (cur != null) {
			System.out.print(cur.value + " ");
			cur = cur.next;
		}
		System.out.println();
		cur = head;
		System.out.print("rand:  ");
		while (cur != null) {
			System.out.print(cur.rand == null ? "- " : cur.rand.value + " ");
			cur = cur.next;
		}
		System.out.println();
	}
	

	public static void main(String[] args) {
		Node head = null;
		Node res1 = null;
		Node res2 = null;
		printRandLinkedList(head);
		res1 = copyListWithRand1(head);
		printRandLinkedList(res1);
		printRandLinkedList(res2);
		printRandLinkedList(head);
		System.out.println("=========================");
		
		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);

		head.rand = head.next.next.next.next.next; // 1 -> 6
		head.next.rand = head.next.next.next.next.next; // 2 -> 6
		head.next.next.rand = head.next.next.next.next; // 3 -> 5
		head.next.next.next.rand = head.next.next; // 4 -> 3
		head.next.next.next.next.rand = null; // 5 -> null
		head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4
		
		
		printRandLinkedList(head);
		res1 = copyListWithRand2(head);
		printRandLinkedList(res1);
		System.out.println("=========================");
	}

}
