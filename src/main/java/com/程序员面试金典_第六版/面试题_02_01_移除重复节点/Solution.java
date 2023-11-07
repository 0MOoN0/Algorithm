package com.程序员面试金典_第六版.面试题_02_01_移除重复节点;

import com.程序员面试金典_第六版.ListNode;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null){
            return null;
        }
        Set<Integer> existSet = new HashSet<Integer>();
        ListNode p = head;
        ListNode q = head.next;
        while(q!=null){
            if(existSet.contains(q.val)){
                p.next = q.next;
                q = q.next;
                continue;
            }
            existSet.add(q.val);
            p=p.next;
            q=q.next;
        }
        return head;
    }

    public static void main(String[] args) {
        // [1, 2, 3, 3, 2, 1]
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(1);
        Solution solution = new Solution();
        ListNode listNode = solution.removeDuplicateNodes(head);
        System.out.println(listNode);
    }

}