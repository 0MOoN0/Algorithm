package com.剑指offer_第二版.四二_连续子数组的最大和;

class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if(max+nums[i] > nums[i]){
                max += nums[i];
            }else{
                max = nums[i];
            }
            res = Math.max(res, max);
        }
        return res;
    }
}