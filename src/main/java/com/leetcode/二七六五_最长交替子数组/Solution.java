package com.leetcode.二七六五_最长交替子数组;

class Solution {
    public int alternatingSubarray(int[] nums) {
        int res = -1;
        int faster = 1;
        int slower = 0;
        int target = -1;
        int curRes = 0;
        while(faster<nums.length){
            if(nums[slower] - nums[faster] == target){
                curRes++;
                target *= -1;
                res = Math.max(res, curRes);
            }else if(nums[slower] - nums[faster] != target && nums[slower] - nums[faster] == -1){
                curRes = 1;
                target = 1;
                res = Math.max(res, curRes);
            }else{
                curRes = 0;
                target = -1;
            }
            faster++;
            slower++;
        }
        return res == -1 ? res : res+1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2,3,4,3,4};
        System.out.println(solution.alternatingSubarray(nums)); // 3
    }

}