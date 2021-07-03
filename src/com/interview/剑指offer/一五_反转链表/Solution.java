package com.interview.剑指offer.一五_反转链表;

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
	public ListNode ReverseList(ListNode head) {
		ListNode newHead = new ListNode(0);
		while (head != null) {
			ListNode temp = head;
			head = head.next;
			ListNode next = newHead.next;
			temp.next = next;
			newHead.next = temp;
		}
		return newHead.next;
	}
}
