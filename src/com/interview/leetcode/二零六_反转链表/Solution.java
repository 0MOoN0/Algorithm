package com.interview.leetcode.������_��ת����;
/**
 * ʹ�õ����ķ�����ʹ��һ��ͷ�ڵ㣬ÿ������൱����ͷ�ڵ�������
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = new ListNode(0);
        ListNode result = pre;
        while(head!=null){
            // �½��ڵ�
            ListNode node = new ListNode(head.val);
            node.next = pre.next;
            // ����һ���ڵ�ָ��ǰ�ڵ�
            pre.next = node;
            // ԭʼͷ�ڵ�ָ����һ��
            head = head.next;
        }
        return result.next;
    }
}