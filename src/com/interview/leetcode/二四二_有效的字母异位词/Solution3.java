package com.interview.leetcode.二四二_有效的字母异位词;

import java.util.ArrayList;

/**
 * 官方题解，使用哈希表
 * 使用一个数组记录每个字符出现过的次数，一个加一，一个减一，如果最后的结果数组元素
不为零，则说明两个字符串的字符出现次数不匹配
 * @author Peter
 *
 */
class Solution3 {
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		int[] counter = new int[26];
		for (int i = 0; i < s.length(); i++) {
			counter[s.charAt(i) - 'a']++;
			counter[t.charAt(i) - 'a']--;
		}
		for (int count : counter) {
			if (count != 0) {
				return false;
			}
		}
		return true;
	}
}