package com.interview.��ָoffer.��_��̬��̨��;

// ������һ����Ŀ�ó����Ӻ���ǰ�����һ����������һ����һ������...n��
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
            // һ����n��
            dp[i] += 1;
        }
        return dp[target-1];
    }
}