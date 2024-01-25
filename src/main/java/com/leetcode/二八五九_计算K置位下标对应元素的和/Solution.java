package com.leetcode.二八五九_计算K置位下标对应元素的和;

import java.util.List;

class Solution {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int res = 0;
        for(int i=0; i<nums.size(); i++){
            if(Integer.bitCount(i) == k){
                res += nums.get(i);
            }
        }
        return res;
    }
}