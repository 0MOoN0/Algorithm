package com.leetcode.二三_合并K个升序链表;

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
 * 解题思路，遍历链表集合，合并所有链表
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null;
        for(int i=0;i<lists.length;i++){
            ans = mergeTwoLists(ans, lists[i]);
        }
        return ans;
    }

    // 合并两条链表
    public ListNode mergeTwoLists(ListNode a, ListNode b){
        if(a==null || b==null){
            return a==null?b:a;
        }
        // 定义头尾指针和ab链表指针
        ListNode head = new ListNode(0);
        ListNode tail=head;
        ListNode aPot = a;
        ListNode bPot = b;
        while(aPot!=null && bPot!=null){
            if(aPot.val < bPot.val){
                tail.next = aPot;
                aPot = aPot.next;
            }else{
                tail.next = bPot;
                bPot = bPot.next;
            }
            tail = tail.next;
        }
        tail.next = aPot==null?bPot:aPot;
        return head.next;
    }

}