package com.leetcode.一三八_复制带随机指针的链表;

/**
 * @author Leon
 */
public class Solution {

    public Node copyRandomList(Node head) {
        if (head==null) return null;
        // 复制链表
        Node pHead = head;
        while(pHead!=null){
            Node node = new Node(pHead.val);
            node.next = pHead.next;
            pHead.next = node;
            pHead = pHead.next.next;
        }
        // 复制随机指针
        pHead = head;
        while(pHead!=null){
            Node random = pHead.random;
            if(random!=null){
                Node cHead = pHead.next;
                cHead.random = random.next;
            }
            pHead = pHead.next.next;
        }
        // 剥离链表
        pHead = head;
        Node cHead = head.next;
        Node _cHead = head.next;
        // 剥离完毕的标志：pHead.next = null && cHead.next = null
        while(pHead.next != null && cHead.next != null){
            pHead.next = cHead.next;
            cHead.next = pHead.next.next;
            pHead = pHead.next;
            cHead = cHead.next;
        }
        return _cHead;
    }

    // 测试
    public static void main(String[] args) {
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        Solution s = new Solution();
        Node head = s.copyRandomList(node1);
        while(head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }

}
