package com.interview.leetcode.九_回文数;

/**
 * 回文数，从左往右读和从右往左读都相同
 * 121是回文数
 * -121不是回文数，121-与-121不相同
 *
 * @author Leon
 */
public class Solution2 {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        char[] strx = String.valueOf(x).toCharArray();
        int left = 0;
        int right = strx.length - 1;
        while (left <= right) {
            if(strx[left] != strx[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution2 s2 = new Solution2();
        boolean palindrome = s2.isPalindrome(1221);
        System.out.println(palindrome);
    }
}
