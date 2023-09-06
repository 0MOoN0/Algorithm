package com.剑指offer_第二版.四六_把数字翻译成字符串;

class Solution {
    public int translateNum(int num) {
        String str = String.valueOf(num);
        int[] dp = new int[str.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= str.length(); i++) {
            int n = str.charAt(i - 1) - '0' + (str.charAt(i - 2) - '0') * 10;
            if (n < 26 && n > 9) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[str.length()];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.translateNum(506);
        System.out.println(i);
    }

}