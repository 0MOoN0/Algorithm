package com.interview.leetcode.һ��һ_λ1�ĸ���;
/**
 * λ���㣬ÿһ�ν�n��һ��1��ȥ��ֱ��n����0Ϊֹ
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