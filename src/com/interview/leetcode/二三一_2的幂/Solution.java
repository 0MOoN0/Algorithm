package com.interview.leetcode.����һ_2����;

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