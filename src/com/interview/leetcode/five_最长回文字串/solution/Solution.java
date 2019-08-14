package com.interview.leetcode.five_最长回文字串.solution;

/**
 * 使用了中心拓展算法， 根据回文字符串的特性设计出来的一种算法
 * 从字串的中心开始，游标向左右两边拓展，如果有一边不满足情况则表示
 * 注意有两种情况：
 *  1. 回文字串是偶数
 *   从i , i+1 作为游标两边，向外拓展
 *  2. 回文字串是奇数
 *   从i作为游标，向两边拓展
 * 
 * @author Peter
 *
 */
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);    //回文子串的长度为奇数时
            int len2 = expandAroundCenter(s, i, i + 1);    //回文子串的长度为偶数时
            int len = Math.max(len1, len2);        //取两种情况中的最大值
            if (len > end - start) {                //满足该条件则为当前的最长回文子串
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }
 
    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;    
        }
        return R - L - 1;
    }
}