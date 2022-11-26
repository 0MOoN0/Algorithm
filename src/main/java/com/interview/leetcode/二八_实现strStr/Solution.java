package com.interview.leetcode.二八_实现strStr;

/**
 * @author Leon
 */
public class Solution {

    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) return 0;
        for (int i = 0; i + needle.length() <= haystack.length(); i++) {
            for (int nIndex = 0; nIndex <= needle.length(); nIndex++) {
                if (nIndex == needle.length()) {
                    return i;
                } else if (!(haystack.charAt(i + nIndex) == needle.charAt(nIndex))) {
                    break;
                }
            }
        }
        return -1;
    }
}
