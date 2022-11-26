package com.interview.剑指offer.四四_翻转单词顺序列;

public class Solution {
	public String ReverseSentence(String str) {
		if (str == null || str.trim().equals(""))
			return str;
		StringBuffer sb = new StringBuffer();
		String[] strs = str.split(" ");
		for (int i = strs.length - 1; 0 <= i; i--) {
			if (i == 0) {
				sb.append(strs[i]);
			} else {
				sb.append(strs[i] + " ");
			}
		}
		return sb.toString();
	}
}
