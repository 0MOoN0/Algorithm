package com.interview.剑指offer.四三_左旋转字符串;

public class Solution {
	public String LeftRotateString(String str, int n) {
		if (str == null || str.equals(""))
			return "";
		int length = str.length();
		return str.substring(n % length, length) + str.substring(0, n % length);
	}
}