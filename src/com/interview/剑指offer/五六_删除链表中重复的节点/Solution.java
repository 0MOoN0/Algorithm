package com.interview.剑指offer.五六_删除链表中重复的节点;
/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {
    public ListNode deleteDuplication(ListNode pHead)
    {
        // 构建一个头节点
        ListNode newHead = new ListNode(-1);
        newHead.next = pHead;
        // 构建一个父节点，指向头节点
        ListNode parent = newHead;
        // 构建一个子节点
        ListNode child = parent.next;
        // 子节点是否重复的标志位
        boolean isReapet = false;
        // 遍历链表
        while(child!=null){
            ListNode temp = child.next;
            // 找到与子节点不相等的第一个节点
            while(temp!=null && temp.val == child.val){
                temp = temp.next;
            }
            // 如果下一个节点与子节点重复，则删除所有相关节点
            if(temp!=child.next){
                parent.next = temp;
                child = parent.next;
                continue;
            }
            child = child.next;
            parent = parent.next;
        }
        return newHead.next;
    }
}
