package com.interview.leetcode.二四二_有效的字母异位词;

import java.util.*;

/**
 * 手写快排
 * @author Peter
 *
 */
class Solution {
	public boolean isAnagram(String s, String t) {
		// 数据校验
		if (!(s != null && t != null && s.length() == t.length())) {
			return false;
		}
		char cs[] = s.toCharArray();
		char ct[] = t.toCharArray();
		// Arrays.sort(cs);
		// Arrays.sort(ct);
		sort(cs, 0, cs.length - 1);
		sort(ct, 0, ct.length - 1);
		for (int i = 0; i < cs.length; i++) {
			if (cs[i] != ct[i])
				return false;
		}
		return true;
	}

	public static int partition(char cs[], int left, int right) {
		char temp = cs[left];
		while (left < right) {
			while (temp <= cs[right] && left < right) {
				right--;
			}
			if (left < right) {
				cs[left] = cs[right];
				left++;
			}
			while (temp >= cs[left] && left < right) {
				left++;
			}
			if (left < right) {
				cs[right] = cs[left];
				right--;
			}
		}
		cs[left] = temp;
		return left;
	}

	public static void sort(char cs[], int left, int right) {
		if (cs == null || left >= right || cs.length <= 1) {
			return;
		}
		int mid = partition(cs, left, right);
		sort(cs, left, mid);
		sort(cs, mid + 1, right);
	}

}