package com.leetcode.二六_删除有序数组中的重复项;

/**
 * 不使用其他的数据结构，需要对原数组进行修改并记录元素个数
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums==null || nums.length == 0) return 0;
        int counter = 1;
        int lastNum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]!=lastNum){
                if(counter != i){
                    nums[counter] = nums[i];
                }
                counter++;
                lastNum = nums[i];
            }
        }
        return counter;
    }
}