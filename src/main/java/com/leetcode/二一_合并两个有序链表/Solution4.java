package com.leetcode.二一_合并两个有序链表;

import java.util.Stack;

/**
 * 使用栈模拟递归
 *
 * @author Leon
 */
public class Solution4 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        Stack<ListNode> stack = new Stack<ListNode>();
        while(l1!=null && l2!=null){
            if(l1.val < l2.val){
                stack.push(l1);
                l1 = l1.next;
            }else{
                stack.push(l2);
                l2 = l2.next;
            }
        }
        ListNode prev = l1==null?l2:l1;
        while(!stack.isEmpty()){
            ListNode pop = stack.pop();
            pop.next = prev;
            prev = pop;
        }
        return prev;
    }

}
