package com.interview.剑指offer.七_斐波那契数列;

public class Solution {
	public int Fibonacci(int n) {
		int dp[] = new int[n + 2];
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i-1]+dp[i-2];
			dp[i-2] = dp[i-1];
//			dp[i-1] = dp[i];
		}
		return dp[n];
	}
}