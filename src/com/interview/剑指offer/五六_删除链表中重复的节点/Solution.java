package com.interview.��ָoffer.����_ɾ���������ظ��Ľڵ�;
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
        // ����һ��ͷ�ڵ�
        ListNode newHead = new ListNode(-1);
        newHead.next = pHead;
        // ����һ�����ڵ㣬ָ��ͷ�ڵ�
        ListNode parent = newHead;
        // ����һ���ӽڵ�
        ListNode child = parent.next;
        // �ӽڵ��Ƿ��ظ��ı�־λ
        boolean isReapet = false;
        // ��������
        while(child!=null){
            ListNode temp = child.next;
            // �ҵ����ӽڵ㲻��ȵĵ�һ���ڵ�
            while(temp!=null && temp.val == child.val){
                temp = temp.next;
            }
            // �����һ���ڵ����ӽڵ��ظ�����ɾ��������ؽڵ�
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