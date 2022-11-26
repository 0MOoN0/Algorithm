package com.interview.剑指offer.二_从尾到头打印链表;
/**
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*
*/
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        while(listNode != null) {
        	arrayList.add(0, listNode.val);
        	listNode = listNode.next;
        }
        return arrayList;
    }
}
