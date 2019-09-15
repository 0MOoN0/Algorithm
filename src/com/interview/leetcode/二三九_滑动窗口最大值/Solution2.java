package com.interview.leetcode.������_�����������ֵ;

import java.util.*;

/**
 * ʹ���������
 * @author Peter
 *
 */
class Solution2 {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length <= 0)
			return new int[] {};
		// �������
		int[] result = new int[nums.length - k + 1];
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k, (o1, o2) -> -(o1 - o2));
		int loder = Integer.MAX_VALUE;

		for (int i = 0, j = 0; i < nums.length; i++) {
			// �Ƴ�������Ԫ��
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