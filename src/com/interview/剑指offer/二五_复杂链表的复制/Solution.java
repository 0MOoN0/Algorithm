package com.interview.��ָoffer.����_��������ĸ���;
/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/
public class Solution {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead==null) return null;
        RandomListNode qHead = new RandomListNode(pHead.label);
        // ����next����
        RandomListNode p = pHead.next;
        RandomListNode q = qHead;
        while(p!=null){
            q.next = new RandomListNode(p.label);
            p = p.next;
            q=q.next;
        }
        // �������ָ��
        p = pHead;
        q = qHead;
        while(p!=null){
            // �ж�randomָ���Ƿ�Ϊ��
            if(p.random!=null){
                // ˫ָ��ͬ�����б������ҳ�p randomָ��Ľڵ�
                RandomListNode pHead_=pHead, qHead_=qHead;
                while(p.random!=pHead_){
                    pHead_ = pHead_.next;
                    qHead_ = qHead_.next;
                }
                q.random = qHead_;
            }
            p=p.next;
            q=q.next;
        }
        return qHead;
    }
}