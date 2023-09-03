package com.剑指offer_第二版.三五_复杂链表的复制;


import com.剑指offer_第二版.Node;
import com.剑指offer_第二版.utils;

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    // 原地复制方法
    public Node copyRandomList(Node head) {
        Node p = head;
        while (p != null) {
            Node n = new Node(p.val);
            n.next = p.next;
            p.next = n;
            p = n.next;
        }
        p = head;
        // 复制random指针
        while (p != null) {
            Node n = p.next;
            if (p.random != null) {
                n.random = p.random.next;
            }
            p = n.next;
        }
        // 分离复制节点，使用一个空白头节点作为辅助
        p = head;
        Node n = new Node(-1);
        Node nHead = n;
        while (p != null) {
            n.next = p.next;
            n = n.next;
            p.next = n.next;
            p = p.next;
        }
        return nHead.next;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.next = node2;
        node1.random = node1;
        node2.random = node1;
        Solution solution = new Solution();
        Node node = solution.copyRandomList(node1);
        utils.printLinkedNode(node);
        utils.printLinkedNode(node1);
    }

}