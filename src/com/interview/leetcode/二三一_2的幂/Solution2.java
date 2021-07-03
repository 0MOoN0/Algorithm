package com.interview.leetcode.二三一_2的幂;

/**
 *  二的次方数有一个特点，大于零并且只有一位是1，因此只要判断n>0 && n的1的个数即可
 * @author Peter
 *
 */
class Solution2 {
	public boolean isPowerOfTwo(int n) {
		int pointer = 1;
		int result = 0;
		for (int i = 0; n > 0 && i < 32; i++) {
			if ((n & pointer) == 1) {
				result++;
			}
			pointer <<= 1;
		}
		return result != 1 ? false : true;
	}
}
