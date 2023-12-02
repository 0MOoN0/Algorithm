package com.leetcode.二三_合并K个升序链表;

import com.程序员面试金典_第六版.ListNode;

public class Solution1 {

    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length-1);
    }

    public ListNode merge(ListNode []lists, int l, int r){
        // 边界情况
        if(l==r){
            return lists[l];
        }
        // 越界
        if(l>r){
            return null;
        }
        // 计算中点
        int mid = (l + r) >> 1;
        // 合并链表并返回
        return mergeTwoLists(merge(lists,l, mid), merge(lists, mid+1, r));
    }

    // 合并两条链表
    public ListNode mergeTwoLists(ListNode a, ListNode b){
        if(a==null || b==null){
            return a==null?b:a;
        }
        // 定义头尾指针和ab链表指针
        ListNode head = new ListNode(0);
        ListNode tail=head;
        ListNode aPot = a;
        ListNode bPot = b;
        while(aPot!=null && bPot!=null){
            if(aPot.val < bPot.val){
                tail.next = aPot;
                aPot = aPot.next;
            }else{
                tail.next = bPot;
                bPot = bPot.next;
            }
            tail = tail.next;
        }
        tail.next = aPot==null?bPot:aPot;
        return head.next;
    }

}
