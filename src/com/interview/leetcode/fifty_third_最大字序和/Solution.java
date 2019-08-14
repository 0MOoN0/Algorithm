package com.interview.leetcode.fifty_third_��������;
/**
 * 
 * @author Peter
 *
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int max = 0;
        for(int i=0; i<nums.length; i++) {
        	// ����i���ʾ������߲����룬��������룬��ֱ��ʹ��i�����ݣ�������룬��max���룬��ѡ���ߵ����ֵ
        	// �¸�ֵ��max��ʾ����i�����ڵ��ִ�
        	if(nums[i]+max > nums[i]) {
        		max+=nums[i];
        	}else {
        		max = nums[i];
        	}
        	ans = Math.max(ans, max);
        }
        return ans;
    }
}