package com.interview.剑指offer.八_跳台阶;

/**
 * 一维DP
 * @author Peter
 *
 */
public class Solution {
	public int JumpFloor(int target) {
		// 判断特殊情况
		int dp[] = new int[target + 2];
		dp[0] = 1;
		dp[1] = 2;
		for (int i = 2; i < target; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[target - 1];
	}
}