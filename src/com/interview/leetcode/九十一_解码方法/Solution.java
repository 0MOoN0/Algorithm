package com.interview.leetcode.九十一_解码方法;
class Solution {
    public int numDecodings(String s) {
    	if(s.length()==0) {
    		return 0;
    	}else if(s.length()==1) {
    		if(s.equals("0")){
    			return 0;
    		}
    		return 1;
    	}
    	int [] cache = new int[]{1,0};
    	int max = 0;
        char[] cs = s.toCharArray();
        for(int i=cs.length-2; 0<=i; i--) {
        	if(cs[i]=='0') {
        		// 如果是遇见0，指针移动两位，更新cache[1]
//        		i--;
//        		cache[1] = cache[0];
        		continue;
        	}
        	if(Integer.parseInt(s.substring(i, i+2))<=26) {
        		if(cache[1]==0) {
        			cache[1]=1;
        		}
        		max = cache[1]+cache[0];
        		cache[1] = cache[0];
        		cache[0] = max;
        	}else {
        		max = cache[0];
        	}
        }
        	
        return max;
    }
}