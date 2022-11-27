package com.leetcode.一七一_Excel表序列号;
/**
 * 根据规律，可以得出第n位的值为:26^(n-1)*数值
 * 数值：字符值-'A'+1
 * @author Peter
 *
 */
class Solution {
    public int titleToNumber(String s) {
        int pow = s.length()-1;
        int result = 0;
        for(int i=0; i<s.length(); i++){
            // 获取当前字符
            char indexC = s.charAt(i);
            // 当前值
            int indexI = (indexC-'A'+1);
            result += indexI * Math.pow(26,pow);
            pow--;
        }
        return result;
    }
}
