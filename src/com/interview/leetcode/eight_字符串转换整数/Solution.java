package com.interview.leetcode.eight_字符串转换整数;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    public int myAtoi(String str) {
    	if(str!=null) {
    		str = str.trim();
    		if("".contentEquals(str)) {
    			return 0;
    		}
    		String resultStr = "";
    		Pattern compile = Pattern.compile("-?\\d+");
    		Matcher matcher = null;
    		// 如果第一位是正或者负号，检查第二个字符
    		if(str.charAt(0)=='+' || str.charAt(0)=='-') {
    			if(str.length()>1 && str.charAt(1)>='0' && str.charAt(1)<='9') {
    				// 通过正则表达式进行筛选
    		    	matcher = compile.matcher(str);
    			}else {
    				return 0;
    			}
    		}else {
    			// 如果非正负，则判断是否为有效字符
    			if(str.charAt(0)>='0' && str.charAt(0)<='9') {
    		    	matcher = compile.matcher(str);
    			}else {
    				// 非有校字符，返回0
    				return 0;
    			}
    		}
	    	if(matcher.find()) {
	    		resultStr = matcher.group();
	    		try {
					return Integer.parseInt(resultStr);
				} catch (NumberFormatException e) {
					if(str.charAt(0)=='+' || (str.charAt(0)>='0' && str.charAt(0)<='9')) {
						return 2147483647;
					}else {
						return -2147483648;
					}
				}
	    	}else {
	    		return 0;
	    	}
    	}else {
    		return 0;
    	}
    }
}