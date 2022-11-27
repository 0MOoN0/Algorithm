package com.leetcode.一二零_三角形最小路径和;

import java.util.List;

/**
动态规划(状态压缩)-AC-2ms
1. 每行的数字都只会使用一次
2. 每一行的数字个数=当前行数
 * @author Peter
 *
 */
class Solution3 {
	public int minimumTotal(List<List<Integer>> triangle) {
		int rowNum = triangle.size(); // 行数
		int[] nums = new int[rowNum + 1];
		for (int row = rowNum - 1; row >= 0; row--) {
			// 计算第row行的最佳状态，如果是最后一行，则对数组进行初始化
			for (int col = 0; col <= row; col++) {
				nums[col] = Math.min(nums[col], nums[col + 1]) + triangle.get(row).get(col);
			}
		}
		return nums[0];
	}
}
