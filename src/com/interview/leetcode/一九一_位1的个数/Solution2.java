package com.interview.leetcode.һ��һ_λ1�ĸ���;

// ��λѭ����������Ϊ�������������32λ�����Ը��Ӷ�ΪO(32)
// &�������㣬��ͬΪһ����ͬΪ��
public class Solution2 {
	// you need to treat n as an unsigned value
	public int hammingWeight(int n) {
		int result = 0;
		int point = 1;
		for (int i = 0; i < 32; i++) {
			if ((n & point) != 0) { // ���Ĵ��룬���n�ĵ�ǰλ��Ϊ1�����Ϊ1����ΪΪ0
				result++;
			}
			point <<= 1;
		}
		return result;
	}
}