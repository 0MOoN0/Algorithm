package com.interview.leetcode.����һ_2����;

/**
 *  ���Ĵη�����һ���ص㣬�����㲢��ֻ��һλ��1�����ֻҪ�ж�n>0 && n��1�ĸ�������
 * @author Peter
 *
 */
class Solution2 {
	public boolean isPowerOfTwo(int n) {
		int pointer = 1;
		int result = 0;
		for (int i = 0; n > 0 && i < 32; i++) {
			if ((n & pointer) == 1) {
				result++;
			}
			pointer <<= 1;
		}
		return result != 1 ? false : true;
	}
}