package com.interview.leetcode.一九一_位1的个数;

// 按位循环遍历，因为给出的数最多是32位，所以复杂度为O(32)
// &，与运算，相同为一，不同为零
public class Solution2 {
	// you need to treat n as an unsigned value
	public int hammingWeight(int n) {
		int result = 0;
		int point = 1;
		for (int i = 0; i < 32; i++) {
			if ((n & point) != 0) { // 核心代码，如果n的当前位数为1，结果为1，否为为0
				result++;
			}
			point <<= 1;
		}
		return result;
	}
}