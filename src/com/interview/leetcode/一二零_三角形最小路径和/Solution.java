package com.interview.leetcode.һ����_��������С·����;

import java.util.List;

// �ݹ�
class Solution {

	int result = Integer.MAX_VALUE;
	int count = 0;

	public int minimumTotal(List<List<Integer>> triangle) {
		recursive(0, 0, triangle);
		return result;
	}

	public void recursive(int m, int n, List<List<Integer>> triangle) {
		// �жϵ�ǰΪֹ�Ƿ�Ϊĩβ
		if (m >= triangle.size() - 1) {
			if (triangle.get(m).get(n) + count < result) {
				result = triangle.get(m).get(n) + count;
				return;
			}
			return;
		}
		// ����ǰ������������
		count += triangle.get(m).get(n);
		// ѭ���ɷ��ʵĽڵ㣬�Խڵ���еݹ�
		for (int i = 0; i < 2; i++) {
			// �ҽڵ�
			recursive(m + 1, n + i, triangle);
		}
		// �ع鵱ǰ���
		count -= triangle.get(m).get(n);
	}
}