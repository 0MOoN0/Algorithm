package com.leetcode.剑指Offer_52_两个链表的第一个公共节点;

/**
 * 无环链表的公共节点，链表呈V字型或Y字型
 * <p>
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 *
 * @author Leon
 */
public class Solution {

    // 思路相同，官方代码简化版
    public ListNode getIntersectionNode_offical(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode p = headA;
        ListNode q = headB;
        while (p != q) {
            p = p == null ? headB : p.next;
            q = q == null ? headA : q.next;
        }
        return p;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int n = 0;
        ListNode pa = headA;
        ListNode qb = headB;
        // 遍历链表，获取链表长度
        while (pa.next != null) {
            pa = pa.next;
            n++;
        }
        while (qb.next != null) {
            qb = qb.next;
            n--;
        }
        // 如果两条链表的最后一个节点不相同，则说明不相交
        if (pa != qb) {
            return null;
        }
        // 让pa指向较长链表一端，qb指向较短链表一端
        pa = n > 0 ? headA : headB;
        qb = pa == headA ? headB : headA;
        // 计算两条链表的长度差
        int abs = Math.abs(n);
        // 让较长一端链表移动abs长度
        while (abs > 0) {
            pa = pa.next;
            abs--;
        }
        // 同时遍历两条链表，找到相同节点
        while (pa != qb) {
            pa = pa.next;
            qb = qb.next;
        }
        return pa;
    }
}
