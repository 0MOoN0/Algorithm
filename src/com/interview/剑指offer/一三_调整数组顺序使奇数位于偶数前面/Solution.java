package com.interview.剑指offer.一三_调整数组顺序使奇数位于偶数前面;

public class Solution {
	public void reOrderArray(int[] array) {
		for (int i = 0; i < array.length; i++) {

			int j = i;
			while (0 < j && array[j] % 2 != 0 && array[j - 1] % 2 == 0) {
				int temp = array[j];
				array[j] = array[j - 1];
				array[j - 1] = temp;
				j--;
			}
		}
	}
}