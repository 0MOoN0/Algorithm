package com.interview.��ָoffer.һ��_�����е�����k���ڵ�;
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/

public class Solution {
	// 1. counter��0��ʼ����
	// 2. ��1�ɵã���������0��ʼ���㣬��kһ����С�ڻ��ߵ���counter
	// 3. ����counter��0���㲢�ҵڶ���ָ���Ѿ�ָ��һ��Ԫ�أ�����counter���ܴ��ڵ���k���ڶ���ָ���counter=k��ʼ��
	public ListNode FindKthToTail(ListNode head, int k) {
		int counter = 0;
		ListNode p, q;
		p = q = head;
		while (q != null) {
			if (counter >= k) {
				p = p.next;
			}
			q = q.next;
			counter++;
		}
		return counter < k ? null : p;
	}
}