package com.interview.��ָoffer.һ��_��������˳��ʹ����λ��ż��ǰ��;

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