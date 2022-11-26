package com.interview.剑指offer.五五_链表中环的入口节点;
/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
import java.util.*;
public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        ListNode slow = pHead;
        ListNode fast = pHead;
        while(fast!=null && fast.next!=null){    // 因为快指针在慢指针前面， 所以只需要对快指针做数据校验
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                fast = pHead;
                while(fast != slow){
                    slow = slow.next;
                    fast = fast.next;
                }
                return fast;
            }
        }
        return null;
    }
}
