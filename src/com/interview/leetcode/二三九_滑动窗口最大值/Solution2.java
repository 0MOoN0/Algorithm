package com.interview.leetcode.二三九_滑动窗口最大值;

import java.util.*;

/**
 * 使用最大堆完成
 * @author Peter
 *
 */
class Solution2 {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length <= 0)
			return new int[] {};
		// 结果数组
		int[] result = new int[nums.length - k + 1];
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k, (o1, o2) -> -(o1 - o2));
		int loder = Integer.MAX_VALUE;

		for (int i = 0, j = 0; i < nums.length; i++) {
			// 移除窗口外元素
			if (queue.size() == k) {
				queue.remove(nums[i - k]);
			}
			queue.add(nums[i]);
			if (i >= k - 1) {
				result[j] = queue.peek();
				j++;
			}
		}
		return result;
	}
}