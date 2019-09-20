package com.interview.leetcode.五零_Pow;

// 分治法-递归实现
class Solution {
	public double myPow(double x, int n) {
		if(n<0) {
			x = 1/x;
			n = -n;
		}
		return devide(x,n);
		
	}
	public double devide(double x, int n) {
		if(n==0) {
			return 1.0;
		}
		double half = devide(x, n/2);
		if(n%2==0) {
			return half*half;
		}else {
			return half*half*x;
		}
	}
	
}