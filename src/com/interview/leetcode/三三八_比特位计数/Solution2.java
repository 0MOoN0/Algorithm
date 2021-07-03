package com.interview.leetcode.三三八_比特位计数;

class Solution2 {
	public int[] countBits(int num) {
		int[] result = new int[num + 1];
		for (int i = 0; i <= num; i++) {
			result[i] = Integer.bitCount(i);
		}
		return result;
	}
}
