package com.interview.��ָoffer.��_��̬��̨��;

/**
 * ÿ��¥�ݶ������Ͳ�������ѡ��һ����n-1��
 * AC - 15ms
 * @author Peter
 *
 */
public class Solution2 {
	public int JumpFloorII(int target) {
		if (target <= 0)
			return 0;
		return 1 << (target - 1);
	}
}