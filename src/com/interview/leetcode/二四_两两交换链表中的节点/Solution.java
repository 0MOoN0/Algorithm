package com.interview.leetcode.二四_两两交换链表中的节点;

/**
 * 边界情况：head可能为null，链表长度可能为单数、双数
 * 当元素只剩下一个的时候，不再进行交换动作
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        // 构建一个头节点
        ListNode newHead = new ListNode(0);
        // 指向当前给定的头节点
        newHead.next = head;
        // 构建一个游标，指向头节点
        ListNode temp = newHead;
        // 如果头节点指向的下一个元素和下下个元素不为空，则进行交换
        while(temp.next!=null && temp.next.next!=null){
            // 构建一个游标，指向头节点的下一个元素
            ListNode cur = temp.next;
            // 构建一个游标，指向头节点的下两个元素
            ListNode next = cur.next;
            // swap
            cur.next = next.next;
            next.next = cur;
            temp.next = next;
            // 移动游标
            temp = temp.next.next;
        }
        return newHead.next;
    }
}
