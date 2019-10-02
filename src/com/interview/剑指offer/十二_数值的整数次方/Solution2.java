package com.interview.��ָoffer.ʮ��_��ֵ�������η�;

public class Solution2 {
	public double Power(double base, int exponent) {
		if (base == 0)
			return 0;
		if (exponent == 0)
			return 1;
		double result = 1;
		int N = exponent > 0 ? exponent : -exponent;
		for (int i = 0; i < N; i++) {
			result = result * base;
		}
		return exponent > 0 ? result : 1 / result;
	}
}