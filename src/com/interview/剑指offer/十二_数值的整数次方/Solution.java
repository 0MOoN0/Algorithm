package com.interview.��ָoffer.ʮ��_��ֵ�������η�;

/**
 * ע��η����п���Ϊ����
 * @author Peter
 *
 */
public class Solution {
	public double Power(double base, int exponent) {
		int N = exponent > 0 ? exponent : -exponent;
		return exponent > 0 ? helper(base, N) : 1 / helper(base, N);
	}

	public double helper(double base, int exponent) {
		// �ݹ���ֹ����
		if (base == 0)
			return 0;
		if (exponent == 0)
			return 1;
		int half = exponent / 2;
		double devide = helper(base, half);
		if (exponent % 2 == 0) { // �ж����Ƿ�Ϊż��
			return devide * devide;
		} else {
			return devide * devide * base;
		}
	}
}