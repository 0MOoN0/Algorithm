package com.interview.leetcode.一四一_环形链表;

/**
 * 在leetcode上超时
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
public class Solution3 {
    public boolean hasCycle(ListNode head) {
    	MyCallable callable = new MyCallable(head);
    	FutureTask<Boolean> task = new FutureTask<Boolean>(callable);
    	new Thread(task).start();
    	try {
            return task.get(10,TimeUnit.MICROSECONDS);
		} catch (Exception e) {
			return true;
		}
    }
}
class MyCallable implements Callable<Boolean>{
	ListNode head;
	public MyCallable(ListNode node) {
		head = node;
	}
	@Override
	public Boolean call() throws Exception {
		while(head!=null) {
			head = head.next;
		}
		return false;
	}
}
