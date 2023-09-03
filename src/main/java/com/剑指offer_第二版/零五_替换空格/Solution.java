package com.剑指offer_第二版.零五_替换空格;

class Solution {
    public String replaceSpace(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            stringBuilder.append(s.charAt(i) == ' ' ? "%20" : s.charAt(i));
        }
        return stringBuilder.toString();
    }
}