package com.leetcode.五八_最后一个单词的长度;

/**
 * @author Leon
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        String[] split = s.trim().split(" ");

        return split.length>0?split[split.length-1].length():0;
    }
}
