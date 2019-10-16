package com.interview.剑指offer.一四_链表中倒数第k个节点;
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/

public class Solution {
	// 1. counter从0开始计算
	// 2. 由1可得，如果坐标从0开始计算，则k一定会小于或者等于counter
	// 3. 由于counter从0计算并且第二个指针已经指向一个元素，所以counter可能大于等于k，第二个指针从counter=k开始走
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