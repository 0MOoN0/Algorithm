package com.leetcode.一九_删除链表的倒数第N个节点;

import com.程序员面试金典_第六版.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 * 解题思路：
 * 1. 双指针，让快指针先走N步，然后让快慢指针一起走，直到快指针走到最后一个节点，慢指针的下一个节点就是要删除的节点。
 * 2. 需要注意的额外情况：
 *      2.1 链表只有一个节点，需要定义一个头节点
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast=head;
        ListNode pre = new ListNode(0);
        ListNode slow = pre;
        pre.next = head;
        // 让fast指针往前移动n步
        for(int i=0;i<n;i++){
            fast = fast.next;
        }
        // 双指针移动，直到fast为null
        while(fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        // slow指针目前指向被删除节点的前一个节点
        slow.next = slow.next.next;
        return pre.next;
    }
}