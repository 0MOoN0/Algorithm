package com.程序员面试金典_第六版.面试题_02_03_删除中间节点;

import com.程序员面试金典_第六版.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    public static final Map myMap = new HashMap();
    public static final int i = 10;

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        solution.deleteNode(node.next);
        System.out.println(node.val);
    }

}