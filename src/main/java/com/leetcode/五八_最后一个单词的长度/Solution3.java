package com.leetcode.五八_最后一个单词的长度;

/**
 * 思路与Solution2相似，获取最后一个空格所在索引，计算字符长度，相当于手写lastIndexOf(" ")
 *
 * @author Leon
 */
public class Solution3 {

    public int lengthOfLastWord(String s) {
        s = s.trim();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                return s.length() - i - 1;
            }
        }
        return s.length();
    }
}
