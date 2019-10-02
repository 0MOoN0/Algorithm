package com.interview.剑指offer.十二_数值的整数次方;

/**
 * 注意次方数有可能为负数
 * @author Peter
 *
 */
public class Solution {
	public double Power(double base, int exponent) {
		int N = exponent > 0 ? exponent : -exponent;
		return exponent > 0 ? helper(base, N) : 1 / helper(base, N);
	}

	public double helper(double base, int exponent) {
		// 递归终止条件
		if (base == 0)
			return 0;
		if (exponent == 0)
			return 1;
		int half = exponent / 2;
		double devide = helper(base, half);
		if (exponent % 2 == 0) { // 判断幂是否为偶数
			return devide * devide;
		} else {
			return devide * devide * base;
		}
	}
}