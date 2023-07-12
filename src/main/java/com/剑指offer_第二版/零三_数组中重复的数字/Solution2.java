package com.剑指offer_第二版.零三_数组中重复的数字;

public class Solution2 {
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; ) {
            if (nums[i] == i) {
                i++;
                continue;
            }
            if (nums[i] == nums[nums[i]]) {
                return nums[i];
            }
            // swap
            int j = nums[nums[i]];
            nums[nums[i]] = nums[i];
            nums[i] = j;
        }
        return -1;
    }
}
