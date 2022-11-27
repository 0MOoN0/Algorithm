package com.leetcode.八三_删除链表中的重复元素;

import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * 使用Set数据结构
 *
 * @author Leon
 */
public class Solution2 {
    public ListNode deleteDuplicates(ListNode head) {
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<Integer>();
        while(head!=null){
            linkedHashSet.add(head.val);
            head = head.next;
        }
        head = new ListNode();
        ListNode index = head;
        Iterator<Integer> iterator = linkedHashSet.iterator();
        while(iterator.hasNext()){
            head.next = new ListNode(iterator.next());
            head = head.next;
        }
        return index.next;
    }
}
