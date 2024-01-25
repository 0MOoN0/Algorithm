package com.leetcode.三零九_买卖股票的最佳时机含冷冻期;

class Solution {
    public int maxProfit(int[] prices) {
        // dp[][0]表示不持股的最大值，dp[][1]表示当天持股的最大值，dp[][2]表示当天卖出的最大值
        int [][] dp = new int [prices.length][3];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;

        for(int i=1; i<prices.length; i++){
            // 当天不持股的情况：1.前一天卖出 2.前一天就没有持股
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][2]);
            // 当天持股的情况：1.昨天不持股，今天买入 2.昨天持股，今天继承昨天的持股情况
            dp[i][1] = Math.max(dp[i-1][0]-prices[i], dp[i-1][1]);
            // 当天卖出的情况：昨天持股，今天卖出
            dp[i][2] = dp[i-1][1] + prices[i];
        }
        return Math.max(dp[prices.length-1][0], dp[prices.length-1][2]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = {1,2,3,0,2};
        System.out.println(solution.maxProfit(prices));
    }

}