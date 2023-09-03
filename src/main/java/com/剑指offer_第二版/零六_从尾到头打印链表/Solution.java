package com.剑指offer_第二版.零六_从尾到头打印链表;

import com.剑指offer_第二版.ListNode;

import java.util.Iterator;
import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode p = head;
        while (p!=null){
            stack.push(p);
            p = p.next;
        }
        int [] res = new int[stack.size()];
        // 遍历栈
        for(int i=0; !stack.isEmpty(); i++){
            res[i] = stack.pop().val;
        }
        return res;
    }
}