package com.leetcode.thirteenth_罗马数字转整数;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

class Solution {
    public int romanToInt(String s) {
        HashMap<String, Integer> map = new HashMap<String,Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        char[] cs = s.toCharArray();
        for(int i=0; i<cs.length; i++) {
        	// 判断三种特殊字符
        	if(cs[i] == 'I' && i<cs.length-1) {
        		if(cs[i+1] == 'V') {
        			result += 4;
        			i++;
        			continue;
        		}else if(cs[i+1] == 'X'){
        			result += 9;
        			i++;
        			continue;
        		}
        	}
        	if(cs[i] == 'X' && i<cs.length-1) {
        		if(cs[i+1] == 'L') {
        			result += 40;
        			i++;
        			continue;
        		}else if(cs[i+1] == 'C'){
        			result += 90;
        			i++;
        			continue;
        		}
        	}
        	if(cs[i] == 'C' && i<cs.length-1) {
        		if(cs[i+1] == 'D') {
        			result += 400;
        			i++;
        			continue;
        		}else if(cs[i+1] == 'M'){
        			result += 900;
        			i++;
        			continue;
        		}
        	}
        	// 其他情况
        	result += map.getOrDefault(cs[i]+"", 0);
        }
    	
    	return result;
    }
}
