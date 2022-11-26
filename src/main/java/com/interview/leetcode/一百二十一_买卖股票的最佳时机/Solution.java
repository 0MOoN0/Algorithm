package com.interview.leetcode.一百二十一_买卖股票的最佳时机;

/**
 * 使用动态规划的思想解题
 * 通过计算最大谷底和谷峰的差来获取最大效益： 
 * 如果有i天，则计算i天内最小谷底和最大谷峰之间的差并保存
 * 如果有i+1天，则计算i+1天内最小谷底和最大谷峰之间的差并与i天内的结果进行比较，从而保证每一次获取的结果都是
 * 最有利的
 * @author Leon
 *
 */
class Solution {
    public int maxProfit(int[] prices) {
    	
    	int min = Integer.MAX_VALUE;
    	int max = 0;
    	
    	for(int i=0; i<prices.length; i++) {
    		if(prices[i] < min) {
    			min = prices[i];
    		}else if(prices[i] - min > max) {
    			max = prices[i] - min;
    		}
    	}
    	return max;
    }
}
