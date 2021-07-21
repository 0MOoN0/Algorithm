package com.interview.leetcode.剑指Offer_52_两个链表的第一个公共节点;

import java.util.HashSet;

/**
 * 使用hashset
 *
 * @author Leon
 */
public class Solution2 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        HashSet<ListNode> hashSet = new HashSet<ListNode>();
        while (headA != null) {
            hashSet.add(headA);
            headA = headA.next;
        }
        while (!hashSet.contains(headB) && headB != null) {
            headB = headB.next;
        }
        return headB;
    }
}
