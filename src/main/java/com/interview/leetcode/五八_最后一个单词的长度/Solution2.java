package com.interview.leetcode.五八_最后一个单词的长度;

/**
 * @author Leon
 */
public class Solution2 {

    public int lengthOfLastWord(String s) {
        s = s.trim();
        int blankIndex = s.lastIndexOf(" ");
        return blankIndex == -1? s.length():s.length()-blankIndex-1;
    }
}
