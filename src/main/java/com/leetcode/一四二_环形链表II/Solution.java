package com.leetcode.一四二_环形链表II;


import com.leetcode.comm.ListNode;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null || head.next.next ==null){
            return null;
        }
        ListNode fastN = head.next.next;
        ListNode slowN = head.next;
        while(fastN != slowN){
            // 无环的情况
            if(fastN==null || fastN.next == null){
                return null;
            }
            fastN = fastN.next.next;
            slowN = slowN.next;
        }
        slowN = head;
        // 有环的情况，两者相遇时，让慢指针回到原点，并统一步长，下一次快慢指针相遇时就是换的入口
        while(fastN!=slowN){
            fastN = fastN.next;
            slowN = slowN.next;
        }
        return slowN;
    }
}