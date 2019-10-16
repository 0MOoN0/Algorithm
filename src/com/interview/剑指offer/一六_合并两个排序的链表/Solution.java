package com.interview.��ָoffer.һ��_�ϲ��������������;

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
	public ListNode Merge(ListNode list1, ListNode list2) {
		ListNode newHead = new ListNode(0);
		ListNode result = newHead;
		ListNode p = list1;
		ListNode q = list2;
		while (p != null && q != null) {
			if (p.val > q.val) {
				newHead.next = q;
				q = q.next;
			} else {
				newHead.next = p;
				p = p.next;
			}
			newHead = newHead.next;
		}
		if (p != null) {
			newHead.next = p;
		} else if (q != null) {
			newHead.next = q;
		}
		return result.next;
	}
}