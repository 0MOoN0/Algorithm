package com.interview.剑指offer.六_旋转数组的最小数字.二分查找;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/9f3231a991af4f55b95579b44b7a01ba
       来源：牛客网
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
				// 如果出现数字相等，范围缩紧
				high = high - 1;
			} else {
				high = mid;
			}
		}
		return array[low];
	}
}
