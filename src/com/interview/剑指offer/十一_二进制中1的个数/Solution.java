package com.interview.剑指offer.十一_二进制中1的个数;

public class Solution {
	public int NumberOf1(int n) {
		return Integer.bitCount(n);
	}
}