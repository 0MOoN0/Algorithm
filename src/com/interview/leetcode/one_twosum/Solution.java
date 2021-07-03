package com.interview.leetcode.one_twosum;

import java.util.Arrays;

class Solution {
	static int [] result = new int[2];
    public int[] twoSum(int[] nums, int target) {
    	for (int i = 0; i < nums.length; i++) {
			for(int j = i+1; j<nums.length; j++) {
				if(nums[i]+nums[j]==target) {
					result[0]=i;
					result[1]=j;
				}
			}
		}
    	return result;
    }
    public static void main(String[] args) {
		int a[] = {2, 7, 11, 15};
		Solution solution = new Solution();
		int[] twoSum = solution.twoSum(a, 9);
		System.out.println(Arrays.toString(twoSum));
	}
}
