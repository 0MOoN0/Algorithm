package com.interview.��ָoffer.�Ķ�_��ΪS����������;

import java.util.*;

//1. ����Ϊ�������У����û����ͬ��Ԫ��
//2. ���������ڣ���һ�����������У���ˣ���ǰ�濪ʼ�Һ����Ԫ�غʹӺ�����ǰ���Ԫ����һ����
//3. ����ǴӺ�����Ԫ�أ������ж�Ӧƥ������ֶԣ������ֶ����㣺Key-array[i]һ��С��array[i]
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
					// ���������List
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