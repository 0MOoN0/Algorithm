package com.interview.剑指offer.四二_和为S的两个数字;

import java.util.*;

//1. 数组为递增数列，因此没有相同的元素
//2. 如果结果存在，则一定是在数组中，因此，从前面开始找后面的元素和从后面找前面的元素是一样的
//3. 如果是从后面找元素，而且有对应匹配的数字对，则数字对满足：Key-array[i]一定小于array[i]
public class Solution {
	public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
		int cj = Integer.MAX_VALUE;
		Object temp = new Object();
		HashMap<Integer, Object> map = new HashMap<Integer, Object>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < array.length; i++) {
			int num = sum - array[i];
			if (map.containsKey(num)) {
				if ((num * array[i]) < cj) {
					cj = num * array[i];
					// 将结果放入List
					result.clear();
					result.add(num);
					result.add(array[i]);
				}
			} else {
				map.put(array[i], temp);
			}
		}
		return result;
	}
}