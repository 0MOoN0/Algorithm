package com.leetcode.二一_合并两个有序链表;

/**
 * 递归：
 * 核心思想，比较两个ListNode，返回串联后的最小者；以此延伸到两堆ListNode，返回某一堆串联后的最小者
 *
 * @author Leon
 */
public class Solution3 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }else if(l2==null){
            return l1;
        }else if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
}
