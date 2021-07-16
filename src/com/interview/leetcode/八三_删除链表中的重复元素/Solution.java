package com.interview.leetcode.八三_删除链表中的重复元素;

/**
 *
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序排列
 *
 * @author Leon
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = head;
        ListNode index = head;
        while(index != null){
            if (pre.val == index.val){
                pre.next = index.next;
            }else{
                pre = pre.next;
            }
            index = index.next;
        }
        return head;
    }
}
