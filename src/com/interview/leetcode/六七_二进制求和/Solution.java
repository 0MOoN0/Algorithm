package com.interview.leetcode.六七_二进制求和;

import javafx.util.Builder;

/**
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 * 主要算法:
 * i = (carry + a + b) % 2
 * carry = (carry + a + b )/ 2
 * <p>
 * 模拟进位计算，从低位开始对齐
 * <p>
 * 注：涉及到char的计算，需要-'0'
 *
 * @author Leon
 */
public class Solution {

    // 对StringBuilder使用append最后reverse，而非insert
    public String addBinary_2(String a, String b) {
        StringBuilder result = new StringBuilder();
        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;
        int carry = 0;
        int plusResult = 0;
        while (aIndex >= 0 && bIndex >= 0) {
            plusResult = (a.charAt(aIndex) - '0') + (b.charAt(bIndex) - '0') + carry;
            result.append(plusResult % 2);
//            result.insert(0, plusResult % 2);
            carry = plusResult / 2;
            aIndex--;
            bIndex--;
        }
        while(aIndex >= 0){
            plusResult = a.charAt(aIndex)-'0' +carry;
            result.append(plusResult % 2);
            carry = plusResult / 2;
            aIndex --;
        }
        while(bIndex >= 0){
            plusResult = b.charAt(bIndex) - '0' + carry;
            result.append( plusResult % 2);
            carry = plusResult / 2;
            bIndex --;
        }
        if (carry > 0){
            result.append(1);
        }
        return result.reverse().toString();
    }

    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;
        int carry = 0;
        int plusResult = 0;
        while (aIndex >= 0 && bIndex >= 0) {
            plusResult = (a.charAt(aIndex) - '0') + (b.charAt(bIndex) - '0') + carry;
            result.insert(0, plusResult % 2);
            carry = plusResult / 2;
            aIndex--;
            bIndex--;
        }
        while(aIndex >= 0){
            plusResult = a.charAt(aIndex)-'0' +carry;
            result.insert(0, plusResult % 2);
            carry = plusResult / 2;
            aIndex --;
        }
        while(bIndex >= 0){
            plusResult = b.charAt(bIndex) - '0' + carry;
            result.insert(0, plusResult % 2);
            carry = plusResult / 2;
            bIndex --;
        }
        if (carry > 0){
            result.insert(0,1);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String s1 = s.addBinary("11", "1");
        System.out.println(s1);
    }
}
