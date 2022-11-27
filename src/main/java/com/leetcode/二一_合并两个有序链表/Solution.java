package com.leetcode.二一_合并两个有序链表;

/**
 * 将上面的链表合并到下面的链表
 * 总体的思想：上面的链表元素拼接到下面的链表
 * 边界处理：
 * 1. 如果上面的链表所有的元素都比下面的小，则直接拼接即可
 * 2. 如果下面的链表所有的元素都比上面的小，直接将下面的链表拼接到上面链表
 * 3. 考虑到空链表的问题，上面链表为空，返回下面链表；下面链表为空，返回上面链表
 *
 * @author Leon
 */
public class Solution {

    // 像排队一样重新整理指针方向，使用一个头节点
    public ListNode mergeTwoListsByOffcial(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode prev = head;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;   // prev不会为空
        }
        // 边界处理，如果某一条链表遍历完毕，则直接将新链表最后的元素指向剩下的链表
        prev.next = l1 == null ? l2 : l1;

        return head.next;
    }


    // 写得太过复杂了，官方简化版更容易理解
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l2 == null) return l1;
        if (l1 == null) return l2;
        ListNode uNode = l1;  // up
        ListNode dNode = l2;  // down
        ListNode dnNode = new ListNode(); // down-previous
        dnNode.next = dNode;
        ListNode unNode = new ListNode(); // up-previous
        unNode.next = uNode;
        while (uNode != null && dNode != null) {
            if (uNode.val < dNode.val) {  // 上面链表元素小于下面的元素
                while (uNode.next != null && uNode.next.val < dNode.val) {
                    uNode = uNode.next;
                }
                unNode = uNode.next;
                uNode.next = dNode;
                uNode = unNode;
            } else {  // 上面链表元素大于等于下面的元素
                while (dNode.next != null && uNode.val >= dNode.next.val) {
                    dNode = dNode.next;
                }
                dnNode = dNode.next;
                dNode.next = uNode;
                uNode = uNode.next;
                dNode.next.next = dnNode;
                dNode = dNode.next;
            }
        }
        return l2.val <= l1.val ? l2 : l1;
    }
}
