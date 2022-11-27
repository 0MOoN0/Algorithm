package com.leetcode.一七三六_替换隐藏的数字得到最晚的时间;

/**
 * @author Leon
 */
public class Solution {
    public String maximumTime(String time) {
        char[] chars = time.toCharArray();
        if (chars[0] == '?' && chars[1] == '?') {
            chars[0] = '2';
            chars[1] = '3';
        } else if (chars[0] == '?') {
            chars[0] = chars[1] - '0' < 4 ? '2' : '1';
        } else if (chars[1] == '?') {
            chars[1] = chars[0] - '0' < 2 ? '9' : '3';
        }
        if(chars[3] == '?'){
            chars[3] = '5';
        }
        if(chars[4] == '?'){
            chars[4] = '9';
        }
        return new String(chars);
    }
}
