package com.leetcode.九十一_解码方法;

/**
 * 使用动态规划的思想解题
 * @author Peter
 * 
 * 参考：https://leetcode-cn.com/problems/decode-ways/solution/fei-bo-na-qi-si-lu-by-dingmin1860
 *
 */
class Solution {
    public int numDecodings(String s) {
    	if(s.charAt(0)=='0') return 0;
    	int [] dp = new int[s.length()+1];
    	dp[0]=dp[1]=1;
    	for(int i=2; i<=s.length(); i++) {
    		if(s.charAt(i-1)!='0') {
    			dp[i]+=dp[i-1];
    		}
    		if(s.charAt(i-2)=='1' || s.charAt(i-2)=='2' && s.charAt(i-1)<='6') {
    			dp[i]+=dp[i-2];
    		}
    	}
        return dp[s.length()];
    }
}
