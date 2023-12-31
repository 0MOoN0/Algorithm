package com.leetcode.一三九_单词拆分;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 思路：
 * 动态规划，将规模缩小，只需要考虑两件事情：
 * 1. 0-j部分的能不能拆分
 * 2. j-i部分的能不能拆分
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        Set wordSet = new HashSet(wordDict);
        // 代表空串
        dp[0] = true;
        // 判断每一个字符能不能拆分，并且将结果缓存到dp数组中
        // 令i=1，是因为substring函数包头不包尾
        for(int i=1;i<=s.length();i++){
            // j 不能等于 i，会越界
            for(int j=0; j<i; j++){
                if(dp[j] && wordSet.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}