package com.程序员面试金典_第六版.面试题_02_02_返回倒数第k个节点;

import com.程序员面试金典_第六版.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int kthToLast(ListNode head, int k) {
        ListNode cur = head, pre = head;
        // 让cur和pre间距保持k
        for(int i=0;i<k;i++){
            cur = cur.next;
        }
        while(cur!=null){
            cur = cur.next;
            pre = pre.next;
        }
        return pre.val;
    }
}