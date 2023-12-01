package com.程序员面试金典_第六版.面试题_02_07_链表相交;

import com.程序员面试金典_第六版.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 * 如果是Y型相交，他们的运行过程如下：
 *  短链走完后切换到长链
 *  长链走完后切换到短链
 *  此时长链和短链剩余元素个数是相同的，如果不相交，他们相同的元素就是Null，否则就是链表相交
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA;
        ListNode B = headB;
        while(A!=B){
            A = A==null?headB:A.next;
            B = B==null?headA:B.next;
        }
        // 如果链表不相交，会返回null，否则返回相交节点
        return A;
    }
}