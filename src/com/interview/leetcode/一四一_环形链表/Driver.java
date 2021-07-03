package com.interview.leetcode.一四一_环形链表;

public class Driver {

	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		Solution3 solution3 = new Solution3();
		boolean hasCycle = solution3.hasCycle(node);
		System.out.println(hasCycle);
		
	}

}
