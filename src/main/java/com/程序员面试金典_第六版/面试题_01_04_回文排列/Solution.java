package com.程序员面试金典_第六版.面试题_01_04_回文排列;

/**
 * 关键思路：组成回文字符串的字母个数只能是偶数个或者一个奇数个，否则无法构成回文字符串。
 */
class Solution {
    public boolean canPermutePalindrome(String s) {
        int res[] = new int[128];
        for(int i=0; i<s.length();i++){
            int index = s.charAt(i);
            res[index] = res[index] > 0 ? res[index]-1:res[index]+1;
        }
        int result = 0;
        for(int i=0; i<res.length; i++){
            result+=res[i];
        }
        return !(result > 1);
    }
}