package com.剑指offer_第二版.二二_链表中倒数第K个节点;

import com.剑指offer_第二版.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        // 双指针，并且让后面的指针距离前面的指针为K
        ListNode front = head;
        ListNode tail = head;
        // 让front走n步
        for (int i = 0; i < k; i++) {
            front = front.next;
        }
        while(front != null){
            front=front.next;
            tail = tail.next;
        }
        return tail;
    }
}