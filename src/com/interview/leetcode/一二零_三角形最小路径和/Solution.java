package com.interview.leetcode.一二零_三角形最小路径和;

import java.util.List;

// 递归
class Solution {

	int result = Integer.MAX_VALUE;
	int count = 0;

	public int minimumTotal(List<List<Integer>> triangle) {
		recursive(0, 0, triangle);
		return result;
	}

	public void recursive(int m, int n, List<List<Integer>> triangle) {
		// 判断当前为止是否为末尾
		if (m >= triangle.size() - 1) {
			if (triangle.get(m).get(n) + count < result) {
				result = triangle.get(m).get(n) + count;
				return;
			}
			return;
		}
		// 将当前结果加入计数器
		count += triangle.get(m).get(n);
		// 循环可访问的节点，对节点进行递归
		for (int i = 0; i < 2; i++) {
			// 右节点
			recursive(m + 1, n + i, triangle);
		}
		// 回归当前结果
		count -= triangle.get(m).get(n);
	}
}