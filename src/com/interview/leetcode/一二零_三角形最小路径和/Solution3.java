package com.interview.leetcode.һ����_��������С·����;

import java.util.List;

/**
��̬�滮(״̬ѹ��)-AC-2ms
1. ÿ�е����ֶ�ֻ��ʹ��һ��
2. ÿһ�е����ָ���=��ǰ����
 * @author Peter
 *
 */
class Solution3 {
	public int minimumTotal(List<List<Integer>> triangle) {
		int rowNum = triangle.size(); // ����
		int[] nums = new int[rowNum + 1];
		for (int row = rowNum - 1; row >= 0; row--) {
			// �����row�е����״̬����������һ�У����������г�ʼ��
			for (int col = 0; col <= row; col++) {
				nums[col] = Math.min(nums[col], nums[col + 1]) + triangle.get(row).get(col);
			}
		}
		return nums[0];
	}
}