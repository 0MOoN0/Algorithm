package com.interview.leetcode.two_两数相加;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } } 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4) 输出：7 ->
 * 0 -> 8 原因：342 + 465 = 807
 */
class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int tempNum = 0, tempNum2 = 0;
		// 初始化结果列表
		ListNode resultList = new ListNode(0);
		ListNode tempList = resultList;
		
		while (l1 != null || l2 != null) {
			if (l1 == null) {
				while(l2!=null) {
					if(tempNum2!=0) {
						if(tempNum2+l2.val>=10) {
							tempNum = (l2.val + tempNum2) % 10;
							tempNum2 = 1;
							tempList.next = new ListNode(tempNum);
							tempList = tempList.next;
							l2 = l2.next;
							continue;
						}
						tempList.next = new ListNode(l2.val+tempNum2);
						tempList = tempList.next;
						l2 = l2.next;
						tempNum2 = 0;
						continue;
					}
					tempList.next = new ListNode(l2.val);
					tempList = tempList.next;
					l2 = l2.next;
				}
				break;
			}
			if (l2 == null) {
				while(l1!=null) {
					if(tempNum2!=0) {
						if(tempNum2+l1.val >= 10) {
							tempNum = (l1.val + tempNum2) % 10;
							tempNum2 = 1;
							tempList.next = new ListNode(tempNum);
							tempList = tempList.next;
							l1 = l1.next;
							continue;
						}
						tempList.next = new ListNode(l1.val+tempNum2);
						tempList = tempList.next;
						l1 = l1.next;
						tempNum2 = 0;
						continue;
					}
					tempList.next = new ListNode(l1.val);
					tempList = tempList.next;
					l1 = l1.next;
				}
				break;
			}
			if (l1.val + l2.val + tempNum2 >= 10) {
				tempNum = (l1.val + l2.val + tempNum2) % 10;
				tempNum2 = 1;
				tempList.next = new ListNode(tempNum);
				tempList = tempList.next;
				l1 = l1.next;
				l2 = l2.next;
				continue;
			}
			tempList.next = new ListNode(l1.val + l2.val + tempNum2);
			tempNum2 = 0;
			tempList = tempList.next;
			l1 = l1.next;
			l2 = l2.next;
		}
		if(tempNum2!=0) {
			tempList.next = new ListNode(1);
		}
		resultList = resultList.next;
		return resultList;
//
//		while (l1 != null && l2 != null || tempNum2 != 0) {
//			// 合并
//			if (l1.val + l2.val + tempNum2 >= 10) {
//				tempNum = (l1.val + l2.val + tempNum2) % 10;
//				tempNum2 = 1;
//				tempList.next = new ListNode(tempNum);
//				tempList = tempList.next;
//
//				l1 = l1.next == null ? null : l1.next;
//				l2 = l2.next == null ? null : l2.next;
//				continue;
//			}
//			tempList.next = new ListNode(l1.val + l2.val + tempNum2);
//			tempNum2 = 0;
//			tempList = tempList.next;
//			l1 = l1.next == null ? null : l1.next;
//			l2 = l2.next == null ? null : l2.next;
//		}
//		if (l1 != null) {
//			// 将l1剩下内容添加到链表
//			while (l1 != null) {
//				tempList.next = new ListNode(l1.val);
//				tempList = tempList.next;
//				l1 = l1.next;
//			}
//			resultList = resultList.next;
//			return resultList;
//		}
//		if (l2 != null) {
//			// 将l2剩下内容添加到链表
//			while (l2 != null) {
//				tempList.next = new ListNode(l2.val);
//				tempList = tempList.next;
//				l2 = l2.next;
//			}
//			resultList = resultList.next;
//			return resultList;
//		}
//		resultList = resultList.next;
//		return resultList;
//		
//		
	}

	public static void main(String[] args) {
		ListNode listNode = new ListNode(9);
		ListNode l1 = listNode;
		listNode.next = new ListNode(8);
//		listNode = listNode.next;
//		listNode.next = new ListNode(3);

		ListNode listNode2 = new ListNode(1);
		ListNode l2 = listNode2;
//		listNode2.next = new ListNode(6);
//		listNode2 = listNode2.next;
//		listNode2.next = new ListNode(4);

		Solution solution = new Solution();
		ListNode result = solution.addTwoNumbers(l1, l2);

		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}

	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
