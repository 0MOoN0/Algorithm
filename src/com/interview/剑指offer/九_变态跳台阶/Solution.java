package com.interview.剑指offer.九_变态跳台阶;

// 根据上一个题目得出，从后往前推最后一步，如果最后一步是一格、两格...n格
// AC-15ms
public class Solution {
    public int JumpFloorII(int target) {
        int dp[] = new int[target+2];
        dp[0] = 1;
        dp[1] = 2;
        for(int i=2; i<target; i++){
            for(int j=0; j<i; j++){
                dp[i] += dp[j];
            }
            // 一次跳n格
            dp[i] += 1;
        }
        return dp[target-1];
    }
}