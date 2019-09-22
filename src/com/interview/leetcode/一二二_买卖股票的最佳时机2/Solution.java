package com.interview.leetcode.一二二_买卖股票的最佳时机2;

/**
 * 贪心算法，只要有赚，立马卖掉股票
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