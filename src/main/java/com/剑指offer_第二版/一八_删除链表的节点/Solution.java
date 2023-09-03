package com.剑指offer_第二版.一八_删除链表的节点;

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
    public ListNode deleteNode(ListNode head, int val) {
        // 使用虚拟头节点+双指针，并将虚拟头节点指向原来的头节点
        ListNode p = new ListNode(-1);
        ListNode nHead = p;
        p.next = head;
        ListNode q = p.next;
        while(q!=null){
            if (q.val == val){
                p.next = q.next;
            }
            p = p.next;
            q = q.next;
        }
        return nHead.next;
    }
}