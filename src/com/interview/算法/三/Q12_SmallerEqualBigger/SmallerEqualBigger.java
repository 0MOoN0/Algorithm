package com.interview.�㷨.��.Q12_SmallerEqualBigger;

import com.interview.�㷨.common.Node;
import com.interview.�㷨.utils.Utils;

/**
 * ����������ĳֵ���ֳ����С���м���ȡ��ұߴ����ʽ
 * ��������ΪС��K������K������K������
 * @author Peter
 *
 */
public class SmallerEqualBigger {
	
	public static Node smallerEqualBigger(Node p, int K) {
		Node cur = p;
		int size = 0;
		// ����������
		while(cur != null) {
			size++;
			cur = cur.next;
		}
		Node[] nodes = new Node[size];
		cur = p;
		// ������תΪ����
		for(int i=0; i<nodes.length; i++) {
			nodes[i] = cur;
			cur = cur.next;
		}
		int lesA=-1,curA = 0, bigA=size;	// С���򣬵����򣬴�����
		// ����ڵ����
		while(curA < bigA) {
			// �����ǰ��С��K����ǰ����С�����ǰһ�������н�������ǰָ��++
			if(nodes[curA].value < K) {
				swap(nodes, ++lesA, curA++);
			}else if(nodes[curA].value == K) {	// �����ǰ������K����Ƚ���һ����
				curA++;
			}else {	// �����ǰ������K�� �򽫵�ǰ����������ǰһ�����н���
				swap(nodes, --bigA, curA);
			}
		}
		// ����������
		for(int i=1; i<nodes.length; i++) {
			nodes[i-1].next = nodes[i];
		}
		// βָ�봦��
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
