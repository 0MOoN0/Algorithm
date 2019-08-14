package com.interview.leetcode.��ʮ��_��ͬ·��;
/**
 * ʹ�ö�̬�滮�㷨
 * @author Peter
 *
 */
class Solution {
    public int uniquePaths(int m, int n) {
    	// m�� n��
    	int [][]dp = new int[n][m];
    	//��ʼ���߿�
    	for(int i=0; i<dp.length; i++) dp[i][0] = 1;
    	for(int i=0; i<dp[0].length; i++) dp[0][i] = 1;    	
    	for(int i=1; i<dp.length; i++) {
    		for(int j=1; j<dp[0].length; j++) {
    			dp[i][j] = dp[i][j-1] + dp[i-1][j];
    		}
    	}
        return dp[n-1][m-1];
    }
}