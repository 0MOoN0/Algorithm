package com.leetcode.一六九_求众数;

// 暴力迭代，使用双重循环
class Solution {
	public int majorityElement(int[] nums) {
		int[] result = new int[2];
		int temp = 1;
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] == nums[j]) {
					temp++;
				}
			}
			if (result[0] < temp) {
				result[0] = temp;
				result[1] = nums[i];
			}
			temp = 1;
		}
		return result[0];
	}
}
