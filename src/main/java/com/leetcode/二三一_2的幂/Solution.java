package com.leetcode.二三一_2的幂;

/**
 * 
 * @author Peter
 *
 */
class Solution {
	public boolean isPowerOfTwo(int n) {
		return n > 0 && (n & (n - 1)) == 0;
	}
}
