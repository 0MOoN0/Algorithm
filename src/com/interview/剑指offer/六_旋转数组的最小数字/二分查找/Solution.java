package com.interview.��ָoffer.��_��ת�������С����.���ֲ���;

/**
 * ���ӣ�https://www.nowcoder.com/questionTerminal/9f3231a991af4f55b95579b44b7a01ba
       ��Դ��ţ����
 * @author Peter
 *
 */
public class Solution {
	public int minNumberInRotateArray(int[] array) {

		int low = 0;
		int high = array.length - 1;
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (array[mid] > array[high]) {
				low = mid + 1;
			} else if (array[mid] == array[high]) {
				// �������������ȣ���Χ����
				high = high - 1;
			} else {
				high = mid;
			}
		}
		return array[low];
	}
}