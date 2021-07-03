package com.interview.剑指offer.三六_两个链表的第一个公共结点;
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
import java.util.HashMap;
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        HashMap<ListNode,Object> map = new HashMap<ListNode,Object>();
        ListNode p = pHead1;
        while(p!=null){
            map.put(p, new Object());
            p = p.next;
        }
        ListNode q = pHead2;
        while(q!=null){
            if(map.get(q)!=null){
                return q;
            }
        }
        return null;
    }
}
