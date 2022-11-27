package com.leetcode.thirteenth_罗马数字转整数.solution2_判断优化;

import java.util.HashMap;

class Solution {
    public int romanToInt(String s) {
        char[] cs = s.toCharArray();
    	HashMap<String,Integer> map = new HashMap<String,Integer>();
    	int result = 0;
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        for(int i=cs.length-1; 0<=i; i--) {
        	if(i != 0) {
        		if(map.get(cs[i]+"")-map.get(cs[i-1]+"") > 0) {
        			result += map.get(cs[i]+"")-map.get(cs[i-1]+"");
        			i--;
        			continue;
        		}else {
        			result += map.get(cs[i]+"");
        		}
        	}else {
        		result += map.get(cs[i]+"");
        	}
        }
    	return result;
    }
}
