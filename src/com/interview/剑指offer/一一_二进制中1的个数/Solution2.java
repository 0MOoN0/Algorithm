package com.interview.��ָoffer.һһ_��������1�ĸ���;

public class Solution2 {
	public int NumberOf1(int n) {
		int result = 0;
		while (n != 0) {
			n &= (n - 1);
			result++;
		}
		return result;
	}
}