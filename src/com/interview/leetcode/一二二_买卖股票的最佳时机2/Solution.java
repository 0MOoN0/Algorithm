package com.interview.leetcode.һ����_������Ʊ�����ʱ��2;

/**
 * ̰���㷨��ֻҪ��׬������������Ʊ
 * @author Peter
 *
 */
class Solution {
	public int maxProfit(int[] prices) {
		int result = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] - prices[i - 1] > 0) {
				result += (prices[i] - prices[i - 1]);
			}
		}
		return result;
	}
}