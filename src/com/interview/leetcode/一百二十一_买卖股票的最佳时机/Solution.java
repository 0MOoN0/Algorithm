package com.interview.leetcode.һ�ٶ�ʮһ_������Ʊ�����ʱ��;

/**
 * ʹ�ö�̬�滮��˼�����
 * ͨ���������ȵ׺͹ȷ�Ĳ�����ȡ���Ч�棺 
 * �����i�죬�����i������С�ȵ׺����ȷ�֮��Ĳ����
 * �����i+1�죬�����i+1������С�ȵ׺����ȷ�֮��Ĳ��i���ڵĽ�����бȽϣ��Ӷ���֤ÿһ�λ�ȡ�Ľ������
 * ��������
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