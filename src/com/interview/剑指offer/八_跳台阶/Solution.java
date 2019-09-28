package com.interview.��ָoffer.��_��̨��;

/**
 * һάDP
 * @author Peter
 *
 */
public class Solution {
	public int JumpFloor(int target) {
		// �ж��������
		int dp[] = new int[target + 2];
		dp[0] = 1;
		dp[1] = 2;
		for (int i = 2; i < target; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[target - 1];
	}
}