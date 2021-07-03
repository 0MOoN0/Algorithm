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
// 1.单链表复制，复制当前节点，并插入到当前节点的后面
// 2.随机指针复制，复制单链表的随机指针
// 3.分离链表
public class Solution2 {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead==null) return null;
        // 1. 单链表复制
        RandomListNode pHead_ = pHead;
        while(pHead != null){
            RandomListNode newNode = new RandomListNode(pHead.label);
            newNode.next = pHead.next;
            pHead.next = newNode;
            pHead = pHead.next.next;
        }
        // 随机指针复制
        pHead = pHead_;
        while(pHead!=null){
            RandomListNode pRandom = pHead.random;
            if(pRandom!=null){
                RandomListNode qHead_ = pHead.next;
                qHead_.random = pRandom.next;
            }
            pHead = pHead.next.next;
        }
        // 分离链表
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
