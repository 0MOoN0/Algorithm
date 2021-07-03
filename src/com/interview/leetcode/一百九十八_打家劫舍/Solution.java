package com.interview.leetcode.一百九十八_打家劫舍;

class Solution {
	public int rob(int[] nums) {
		if (nums == null) {
			return 0;
		} else if (nums.length == 0) {
			return 0;
		} else if (nums.length == 1) {
			return nums[0];
		}
		if (nums.length == 2) {
			return Math.max(nums[0], nums[1]);
		}
		int preOne = Math.max(nums[0], nums[1]);
		int preTwo = nums[0];
		int max = 0;
		for (int i = 1; i < nums.length; i++) {
			max = preOne > preTwo + nums[i] ? preOne : preTwo + nums[i];
			preTwo = preOne;
			preOne = max;
		}
		return max;
	}
}
