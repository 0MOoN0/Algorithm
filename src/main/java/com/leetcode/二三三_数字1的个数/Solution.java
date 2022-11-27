package com.leetcode.二三三_数字1的个数;

/**
 * @author Leon
 */
public class Solution {

    public int countDigitOne(int n) {
        int result = 0;
        StringBuffer stringBuffer = new StringBuffer();
        for (; n > 0; n--) {
            stringBuffer.append(n);
            for (int j = 0; j < stringBuffer.length(); j++) {
                if('1'==stringBuffer.charAt(j)){
                    result++;
                }
            }
            stringBuffer.setLength(0);
        }
        return result;
    }
}
