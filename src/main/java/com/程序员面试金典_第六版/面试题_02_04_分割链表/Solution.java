package com.程序员面试金典_第六版.面试题_02_04_分割链表;


import com.程序员面试金典_第六版.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 解题思路：将链表分成小于x和大于等于x的两部分链表，然后拼接两个链表。这种思路也可以用于链表将元素分成小于x、等于x、大于x三部分
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode smaller = new ListNode(-1);
        ListNode smallerHead = smaller;
        ListNode bigger = new ListNode(-1);
        ListNode biggerHead = bigger;
        while(head!=null){
            if (head.val < x){
                smaller.next = head;
                smaller = smaller.next;
            }else{
                bigger.next = head;
                bigger = bigger.next;
            }
            head = head.next;
        }
        // smaller和bigger都不会为空，所以如果smaller要拼接bigger链表只需要将smaller的尾指针指向bigger链表就行
        smaller.next = biggerHead.next;
        // 避免出现bigger链表尾指针指向samller元素导致循环链表
        bigger.next = null;
        return smallerHead.next;
    }

    public static void main(String[] args) {
        // 构建listnode：143252
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        Solution solution = new Solution();
        ListNode partition = solution.partition(head, 3);
        // 打印链表
        while (partition != null) {
            System.out.println(partition);
            partition = partition.next;
        }
    }

}