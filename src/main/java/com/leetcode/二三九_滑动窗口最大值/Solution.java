package com.leetcode.二三九_滑动窗口最大值;

import java.util.*;

/**
 * 使用双端队列完成
 */
class Solution {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length <= 0)
			return new int[] {};
		// 结果数组
		int[] result = new int[nums.length - k + 1];
		Deque<Integer> deque = new LinkedList<Integer>();

		for (int i = 0, j = 0; i < nums.length; i++) {
			// 从后往前poll掉比将入队元素小的元素
			while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
				deque.pollLast();
			}
			deque.addLast(i);
			// poll掉滑动窗口后，窗口外的元素
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
