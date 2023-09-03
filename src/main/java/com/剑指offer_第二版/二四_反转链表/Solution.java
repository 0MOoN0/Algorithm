package com.剑指offer_第二版.二四_反转链表;

import com.剑指offer_第二版.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode tail = null, cur = head, front = null;
        while (cur != null) {
            front = cur.next;
            cur.next = tail;
            tail = cur;
            cur = front;
        }
        return tail;
    }
}