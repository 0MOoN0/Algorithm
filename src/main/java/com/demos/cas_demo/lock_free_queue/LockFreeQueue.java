package com.demos.cas_demo.lock_free_queue;

import java.util.concurrent.atomic.AtomicReference;

public class LockFreeQueue<E> {
    //定义一个链表节点
    private static class Node<E> {
        final E item;
        final AtomicReference<Node<E>> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = new AtomicReference<>(next);
        }
    }

    //定义队列头尾节点
    private final Node<E> dummy = new Node<>(null, null);
    private final AtomicReference<Node<E>> head = new AtomicReference<>(dummy);
    private final AtomicReference<Node<E>> tail = new AtomicReference<>(dummy);

    //入队操作
    public void enqueue(E item) {
        if (item == null) throw new NullPointerException();
        Node<E> newNode = new Node<>(item, null); //创建新节点
        while (true) {
            Node<E> curTail = tail.get(); //获取当前尾节点
            Node<E> tailNext = curTail.next.get(); //获取尾节点的后继节点
            if (curTail == tail.get()) { //检查尾节点是否被其他线程修改
                if (tailNext != null) { //如果尾节点的后继节点不为空，说明有新节点入队，但尾节点还没更新
                    tail.compareAndSet(curTail, tailNext); //尝试更新尾节点为后继节点
                } else {
                    if (curTail.next.compareAndSet(null, newNode)) { //如果尾节点的后继节点为空，说明没有新节点入队，尝试将新节点链接到尾节点
                        tail.compareAndSet(curTail, newNode); //尝试更新尾节点为新节点
                        return; //入队成功，退出循环
                    }
                }
            }
        }
    }

    //出队操作
    public E dequeue() {
        while (true) {
            Node<E> curHead = head.get(); //获取当前头节点
            Node<E> curTail = tail.get(); //获取当前尾节点
            Node<E> headNext = curHead.next.get(); //获取头节点的后继节点
            if (curHead == head.get()) { //检查头节点是否被其他线程修改
                if (curHead == curTail) { //如果头节点等于尾节点，说明队列为空或者只有一个元素
                    if (headNext == null) { //如果头节点的后继节点为空，说明队列为空
                        return null; //出队失败，返回空值
                    } else {
                        tail.compareAndSet(curTail, headNext); //如果头节点的后继节点不为空，说明只有一个元素，尝试更新尾节点为后继节点
                    }
                } else {
                    E item = headNext.item; //如果头节点不等于尾节点，说明队列有多个元素，取出头节点的后继节点的数据项
                    if (head.compareAndSet(curHead, headNext)) { //尝试更新头节点为后继节点
                        return item; //出队成功，返回数据项
                    }
                }
            }
        }
    }
}
