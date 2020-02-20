package com.interview.�㷨.��.Q12_SmallerEqualBigger;

import com.interview.�㷨.common.Node;
import com.interview.�㷨.utils.Utils;

/**
 * ����������ĳֵ���ֳ����С���м���ȡ��ұߴ����ʽ
 * ��������ΪС��K������K������K������
 * ����һ��ʹ������+����ĺ����������� (�޷���֤Ԫ�ص��ȶ���)
 * �����������ƺ����������⣬ʹ��������ɣ���������Ϊ����K������K��С��K���������� �ٽ�������������(���Ա�֤Ԫ�ص��ȶ���)
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
	
	
	public static Node smallerEqualBigger2(Node p, int K) {
		// �������������򣬴��ڣ�С�ڣ�����
		Node bigH = null;	// �������ͷ
		Node bigT = null;	// �������β
		Node equalH = null;
		Node equalT = null;
		Node smallH = null;
		Node smallT = null;
		Node next = null;	// ��һ���ڵ�
		while(p != null) {
			next = p.next;
			p.next = null;
			if(p.value < K) {
				if(smallH == null) {
					smallH = p;
					smallT = p;
				}else {
					smallT.next = p;
					smallT = smallT.next;
				}
				
			}else if(p.value == K) {
				if(equalH == null) {
					equalH = p;
					equalT = p;
				}else {
					equalT.next = p;
					equalT = equalT.next;
				}
			}else {
				if(bigH == null) {
					bigH = p;
					bigT = p;
				}else {
					bigT.next = p;
					bigT = bigT.next;
				}
			}
			p = next;
		}
		// ������������
		if(smallH != null) {
			smallT.next = equalH != null ? equalH : bigH;
		}
		if(equalH != null) {
			equalT.next = bigH;
		}
		return smallH == null ? (equalH == null? bigH : equalH) :smallH;
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
		Node head2 = new Node(7);
		head2.next = new Node(9);
		head2.next.next = new Node(1);
		head2.next.next.next = new Node(8);
		head2.next.next.next.next = new Node(5);
		head2.next.next.next.next.next = new Node(2);
		head2.next.next.next.next.next.next = new Node(5);
		Node result2 = smallerEqualBigger2(head2, 6);
		Utils.printLinkedList(result2);
		
	}

}
