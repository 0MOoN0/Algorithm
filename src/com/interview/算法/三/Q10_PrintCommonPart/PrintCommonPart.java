package com.interview.算法.三.Q10_PrintCommonPart;

/**
 * 打印链表公共部分
 * 给定两个有序链表的头指针head1和head2，打印两个链表的公共部分。
 * input:
 * 2 3 5 6 
 * 1 2 5 7 8 
 * output:
 * 2 5 
 * @author Peter
 *
 */
public class PrintCommonPart {

	public static class Node {
		public int value;
		public Node next;
		public Node(int data) {
			this.value = data;
		}
	}
	
	public static void printfCommonPart(Node p, Node q) {
		while(p!=null && q!=null) {
			if(p.value == q.value) {
				System.out.print(p.value + " ");
				p = p.next;
				q = q.next;
			}else if(p.value < q.value) {
				p = p.next;
			}else if(p.value > q.value) {
				q = q.next;
			}
		}
	}
	
	public static void printLinked(Node p) {
		while(p!=null) {
			System.out.print(p.value+" ");
			p=p.next;
		}
		System.out.println();
	}
	
	// for test
	public static void main(String[] args) {
		Node node1 = new Node(2);
		node1.next = new Node(3);
		node1.next.next = new Node(5);
		node1.next.next.next = new Node(6);

		Node node2 = new Node(1);
		node2.next = new Node(2);
		node2.next.next = new Node(5);
		node2.next.next.next = new Node(7);
		node2.next.next.next.next = new Node(8);
		
		printLinked(node1);
		printLinked(node2);
		printfCommonPart(node1, node2);
	}

}
