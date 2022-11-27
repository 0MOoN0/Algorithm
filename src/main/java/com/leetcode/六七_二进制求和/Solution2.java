package com.leetcode.六七_二进制求和;

import java.math.BigInteger;

/**
 * 使用Integer.parseInt，进行二进制运算
 *
 * @author Leon
 */
public class Solution2 {
    public String addBinary(String a, String b) {
        BigInteger ba = new BigInteger(a, 2);
        BigInteger bb = new BigInteger(b, 2);
        return ba.add(bb).toString(2);
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        String s1 = s.addBinary("11", "1");
        System.out.println(s1);
    }

}
