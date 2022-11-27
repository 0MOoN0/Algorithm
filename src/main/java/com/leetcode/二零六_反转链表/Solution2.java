package com.leetcode.二零六_反转链表;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution2 {
    public ListNode reverseList(ListNode head) {
        ListNode pNode = null;
        ListNode nNode = null;
        while (head != null) {
            nNode = head.next;
            head.next = pNode;
            pNode = head;
            head = nNode;
        }
        return pNode;
    }
}