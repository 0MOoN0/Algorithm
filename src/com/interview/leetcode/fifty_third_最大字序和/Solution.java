package com.interview.leetcode.fifty_third_最大字序和;
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
        	// 对于i项，表示加入或者不加入，如果不加入，则直接使用i项内容，如果加入，则将max加入，在选两者的最大值
        	// 新赋值的max表示包含i项在内的字串
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