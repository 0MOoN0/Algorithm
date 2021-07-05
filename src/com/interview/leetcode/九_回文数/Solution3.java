package com.interview.leetcode.九_回文数;

/**
 * 回文数，从左往右读和从右往左读都相同
 * 121是回文数
 * -121不是回文数，121-与-121不相同
 * 题解三：反转一半数字，反转的过程中，原数字会越来越小
 *     当小于反转后的数字，返回false
 *     当等于反转后的数字，返回true
 * 边界处理：
 *     如果数字的最后一位为0，该数字不可能为回文数
 *     如果是数字位数为奇数(121)，则x = reversed/10：当x=1时，reversed=12，所以x = reversed/10
 *     如果是数字位数为偶数(1221)，则x = reversed：当x=12时，reversed=12，所以x = reversed
 * @author Leon
 */
public class Solution3 {

    public boolean isPalindrome(int x) {
        if (x < 0 || ((x != 0) && (x % 10 == 0))) return false;
        int reversed = 0;
        while (x >= reversed) {
            // 获取原数字最后一位
            reversed = reversed * 10 + x % 10;
            // 原数字去掉最后一位
            x /= 10;
            if (x == reversed || x == reversed / 10) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution3 s3 = new Solution3();
        boolean palindrome = s3.isPalindrome(1234567899);
        System.out.println(palindrome);
    }

}
