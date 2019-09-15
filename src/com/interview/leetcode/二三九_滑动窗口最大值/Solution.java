package com.interview.leetcode.������_�����������ֵ;

import java.util.*;

/**
 * ʹ��˫�˶������
 */
class Solution {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length <= 0)
			return new int[] {};
		// �������
		int[] result = new int[nums.length - k + 1];
		Deque<Integer> deque = new LinkedList<Integer>();

		for (int i = 0, j = 0; i < nums.length; i++) {
			// �Ӻ���ǰpoll���Ƚ����Ԫ��С��Ԫ��
			while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
				deque.pollLast();
			}
			deque.addLast(i);
			// poll���������ں󣬴������Ԫ��
			if (deque.peekFirst() == i - k) {
				deque.pollFirst();
			}
			if (i >= k - 1) {
				result[j] = nums[deque.peekFirst()];
				j++;
			}
		}
		return result;
	}
}