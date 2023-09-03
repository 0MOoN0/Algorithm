package com.leetcode.八零_删除有序数组中的重复项II;

import java.util.ArrayList;

class Solution {
    public int removeDuplicates(int[] nums) {
        int[] curCheck = {nums[0], 1};
        int rl = 1;
        // 第一轮：标记
        for(int i=1;i<nums.length;i++){
            if(nums[i] == curCheck[0]){
                if(curCheck[1] >= 2){
                    nums[i] = Integer.MIN_VALUE;
                    continue;
                }
                curCheck[1]++;
                rl++;
                continue;
            }
            rl++;
            curCheck[0] = nums[i];
            curCheck[1] = 1;
        }
        int curD = -1;
        // 第二轮：移动
        for(int i=1;i<nums.length;i++){
            if(nums[i] == Integer.MIN_VALUE && curD == -1){
                curD = i;
            }
            if(nums[i] != Integer.MIN_VALUE && curD > 0){
                nums[curD++] = nums[i];
            }
        }
        return rl;
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{0,0,1,1,1,1,2,3,3};
        int[] arr = new int[]{1,1,1,2,2,2,3,3};
        Solution solution = new Solution();
        int len = solution.removeDuplicates(arr);
        System.out.println(len);
    }

}