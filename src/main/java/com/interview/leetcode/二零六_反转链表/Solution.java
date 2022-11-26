package com.interview.leetcode.二零六_反转链表;
/**
 * 使用迭代的方法，使用一个头节点，每次添加相当于在头节点后面插入
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = new ListNode(0);
        ListNode result = pre;
        while(head!=null){
            // 新建节点
            ListNode node = new ListNode(head.val);
            node.next = pre.next;
            // 让上一个节点指向当前节点
            pre.next = node;
            // 原始头节点指向下一个
            head = head.next;
        }
        return result.next;
    }
}
