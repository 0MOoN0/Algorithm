package com.剑指offer_第二版.三九_数组中出现次数超过一半的数字;

import java.util.Arrays;

class Solution {
    // 根据题目规律，数组中会出现次数超过一半的数字，排序后，取数组中间的值就可以了
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}