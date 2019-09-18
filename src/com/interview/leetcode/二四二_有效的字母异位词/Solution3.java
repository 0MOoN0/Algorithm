package com.interview.leetcode.���Ķ�_��Ч����ĸ��λ��;

import java.util.ArrayList;

/**
 * �ٷ���⣬ʹ�ù�ϣ��
 * ʹ��һ�������¼ÿ���ַ����ֹ��Ĵ�����һ����һ��һ����һ��������Ľ������Ԫ��
��Ϊ�㣬��˵�������ַ������ַ����ִ�����ƥ��
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