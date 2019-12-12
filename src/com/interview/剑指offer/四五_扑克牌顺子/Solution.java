package com.interview.剑指offer.四五_扑克牌顺子;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {
	public boolean isContinuous(int[] numbers) {
		if (numbers == null || numbers.length < 5)
			return false;
		int zeroNum = 0;
		int size = numbers.length;
		Arrays.sort(numbers);
		// 计算零的个数
		for (int i = 0; i < 5 && numbers[i] == 0; i++) {
			zeroNum++;
		}
		// 去重
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < numbers.length; i++) {
			set.add(numbers[i]);
		}
		if (zeroNum > 0 && size - zeroNum + 1 != set.size()) {
			return false;
		}
		return numbers[size - 1] - numbers[zeroNum] < 5 ? true : false;
	}
}