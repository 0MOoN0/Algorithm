package com.interview.��ָoffer.��һ_��ΪS����������������;

// 1.�����һ����������
// 2.����ӵ���ҪС�ڻ����sum/2
// 2.1.�����ȣ���һ����ȥ�����ף������һ����
// 2.2.�������Ŀ��������ȥ������
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
				// ȥ�����ף����һ����
				int num = tempList.remove(0);
				tempList.add(i);
				result -= num;
				result += i;
			} else if (result > sum) {
				// ȥ�����ף�ֱ��result<=sum
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