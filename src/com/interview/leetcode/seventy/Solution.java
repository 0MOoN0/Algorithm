package com.interview.leetcode.seventy;
class Solution {
    public int climbStairs(int n) {
        if(n==1) {
        	return 1;
        }else if(n==2) {
        	return 2;
        }else if(n==0) {
        	return 0;
        }
    	// n-1По
    	int a=2;
    	// n-2По
    	int b=1;
    	int result = 0;
    	for(int i=3; i<=n; i++) {
    		result = a+b;
    		b = a;
    		a = result;
    	}
    	return result;
    }
}