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
// 1.�������ƣ����Ƶ�ǰ�ڵ㣬�����뵽��ǰ�ڵ�ĺ���
// 2.���ָ�븴�ƣ����Ƶ���������ָ��
// 3.��������
public class Solution2 {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead==null) return null;
        // 1. ��������
        RandomListNode pHead_ = pHead;
        while(pHead != null){
            RandomListNode newNode = new RandomListNode(pHead.label);
            newNode.next = pHead.next;
            pHead.next = newNode;
            pHead = pHead.next.next;
        }
        // ���ָ�븴��
        pHead = pHead_;
        while(pHead!=null){
            RandomListNode pRandom = pHead.random;
            if(pRandom!=null){
                RandomListNode qHead_ = pHead.next;
                qHead_.random = pRandom.next;
            }
            pHead = pHead.next.next;
        }
        // ��������
        RandomListNode qHead = pHead_.next, qHead_=qHead;
        pHead = pHead_;
        while(pHead.next!=null && qHead_.next!=null){
            pHead.next = qHead_.next;
            qHead_.next = pHead.next.next;
            pHead = pHead.next;
            qHead_ = qHead_.next;
        }
//        return pHead.next;
        return qHead;
    }
}