package com.leetcode.三三八_比特位计数;

class Solution {
	public int[] countBits(int num) {
		int[] result = new int[num + 1];
		for (int i = 0; i <= num; i++) {
			int numCount = 0;
			int n = i;
			while (n != 0) {
				n &= (n - 1);
				numCount++;
			}
			result[i] = numCount;
		}
		return result;
	}
}
