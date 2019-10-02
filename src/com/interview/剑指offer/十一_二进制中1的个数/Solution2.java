package com.interview.剑指offer.十一_二进制中1的个数;

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