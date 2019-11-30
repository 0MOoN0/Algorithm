package com.interview.剑指offer.四一_和为S的连续正整数序列;

// 1.结果是一组连续正数
// 2.新添加的数要小于或等于sum/2
// 2.1.如果相等，下一部则去掉队首，再添加一个数
// 2.2.如果大于目标数，则去掉队首
import java.util.ArrayList;

public class Solution {
	public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		int result = 0;
		ArrayList<Integer> tempList = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
		for (int i = 1; i <= sum; i++) {
			if (result < sum) {
				result += i;
				tempList.add(i);
			} else if (result == sum) {
				resultList.add(new ArrayList<Integer>(tempList));
				// 去掉队首，添加一个数
				int num = tempList.remove(0);
				tempList.add(i);
				result -= num;
				result += i;
			} else if (result > sum) {
				// 去掉队首，直到result<=sum
				while (tempList.size() > 0 && result >= sum) {
					if (result == sum) {
						resultList.add(new ArrayList<Integer>(tempList));
						break;
					}
					int num = tempList.remove(0);
					result -= num;
				}
				tempList.add(i);
				result += i;
			}
		}
		return resultList;
	}
}