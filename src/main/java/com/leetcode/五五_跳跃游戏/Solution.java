package com.leetcode.五五_跳跃游戏;

/**
 * 解题思路：
 *
 * 1. 每一步都判断是否可达并且是否超过当前可达的最大值
 * 2. 如果不可达，返回false
 * 3. 可达并且超过当前可达的最大值，则更新可达值。遍历完成后返回true
 */
class Solution {
    public boolean canJump(int[] nums) {
        // 每一步都判断是否可达并且是否超过当前可达的最大值
        int reachable = nums[0];
        for(int i=1; i<nums.length;i++){
            // 判断是否可达
            if(reachable < i){
                return false;
            }
            // 判断可达是否超过目前的最大值
            reachable = reachable < (i + nums[i])? (i + nums[i]) : reachable; 
        }
        return true;
    }
}