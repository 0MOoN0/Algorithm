package com.interview.剑指offer.二五_复杂链表的复制;
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
        // 复制next单链
        RandomListNode p = pHead.next;
        RandomListNode q = qHead;
        while(p!=null){
            q.next = new RandomListNode(p.label);
            p = p.next;
            q=q.next;
        }
        // 复制随机指针
        p = pHead;
        q = qHead;
        while(p!=null){
            // 判断random指针是否为空
            if(p.random!=null){
                // 双指针同步进行遍历，找出p random指向的节点
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
