package com.interview.leetcode.一九一_位1的个数;
/**
 * 位运算，每一次将n的一个1消去，直到n等于0为止
 * @author Peter
 *
 */
public class Solution {
	// you need to treat n as an unsigned value
	public int hammingWeight(int n) {
		int result = 0;
		while (n != 0) {
			n = n & (n - 1);
			result++;
		}
		return result;
	}
}