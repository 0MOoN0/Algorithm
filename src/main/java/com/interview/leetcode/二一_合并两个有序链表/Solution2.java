package com.interview.leetcode.二一_合并两个有序链表;

/**
 * 遍历两个链表，将两个链表复制到一个新的链表
 * 遍历时新建链表节点，并返回。
 * 边界处理：
 *      1.当l1为空或l2为空，或者两者都为空时，返回可能非空的那一个链表
 *      2.当l1或L2已经遍历完，则直接拼接剩下的链表即可，不用创建新对象
 *
 * @author Leon
 */
public class Solution2 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode newList = new ListNode();
        ListNode result = newList;
        newList.next = result;
        ListNode uNode = l1;  // up
        ListNode dNode = l2;  // down
        while (uNode != null && dNode != null) {
            if (uNode.val > dNode.val) {
                result.next = new ListNode(dNode.val);
                result = result.next;
                dNode = dNode.next;
                if (dNode == null) {
                    result.next = uNode;
                    break;
                }
                continue;
            }
            result.next = new ListNode(uNode.val);
            result = result.next;
            uNode = uNode.next;
            if (uNode == null) {
                result.next = dNode;
                break;
            }
        }
        return newList.next;
    }
}
