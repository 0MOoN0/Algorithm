package com.interview.��ָoffer.����_����ת�ַ���;

public class Solution {
	public String LeftRotateString(String str, int n) {
		if (str == null || str.equals(""))
			return "";
		int length = str.length();
		return str.substring(n % length, length) + str.substring(0, n % length);
	}
}