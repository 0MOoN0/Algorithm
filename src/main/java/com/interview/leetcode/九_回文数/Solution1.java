package com.interview.leetcode.九_回文数;

/**
 * 回文数，从左往右读和从右往左读都相同
 * 121是回文数
 * -121不是回文数，121-与-121不相同
 * @author Leon
 *
 */
public class Solution1 {
	
    public boolean isPalindrome(int x) {
    	if (x<0) {
    		return false;
    	}
    	return new StringBuffer(x+"").reverse().toString().equals(x+"");
    }
	

	public static void main(String[] args) {
		Solution1 solution1 = new Solution1();
		boolean palindrome = solution1.isPalindrome(1234567899);
		System.out.println(palindrome);
	}

}
