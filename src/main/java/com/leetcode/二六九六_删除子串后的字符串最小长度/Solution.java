package com.leetcode.二六九六_删除子串后的字符串最小长度;

class Solution {
    public int minLength(String s) {
        StringBuilder sb = new StringBuilder(s);
        int abIndex = sb.indexOf("AB");
        int cdIndex = sb.indexOf("CD");
        while (abIndex != -1 || cdIndex != -1) {
            if (abIndex != -1) {
                sb.replace(abIndex, abIndex + 2, "");
                abIndex = sb.indexOf("AB");
                cdIndex = sb.indexOf("CD");
            }
            if (cdIndex != -1) {
                sb.replace(cdIndex, cdIndex + 2, "");
                abIndex = sb.indexOf("AB");
                cdIndex = sb.indexOf("CD");
            }
        }
        return s.length();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minLength("ABFCACDB")); // 输出 3
    }
}