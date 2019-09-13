package com.interview.leetcode.����_�������������еĽڵ�;

/**
 * �߽������head����Ϊnull�������ȿ���Ϊ������˫��
 * ��Ԫ��ֻʣ��һ����ʱ�򣬲��ٽ��н�������
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        // ����һ��ͷ�ڵ�
        ListNode newHead = new ListNode(0);
        // ָ��ǰ������ͷ�ڵ�
        newHead.next = head;
        // ����һ���αָ꣬��ͷ�ڵ�
        ListNode temp = newHead;
        // ���ͷ�ڵ�ָ�����һ��Ԫ�غ����¸�Ԫ�ز�Ϊ�գ�����н���
        while(temp.next!=null && temp.next.next!=null){
            // ����һ���αָ꣬��ͷ�ڵ����һ��Ԫ��
            ListNode cur = temp.next;
            // ����һ���αָ꣬��ͷ�ڵ��������Ԫ��
            ListNode next = cur.next;
            // swap
            cur.next = next.next;
            next.next = cur;
            temp.next = next;
            // �ƶ��α�
            temp = temp.next.next;
        }
        return newHead.next;
    }
}