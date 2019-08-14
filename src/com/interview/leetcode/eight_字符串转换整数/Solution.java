package com.interview.leetcode.eight_�ַ���ת������;

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
    		// �����һλ�������߸��ţ����ڶ����ַ�
    		if(str.charAt(0)=='+' || str.charAt(0)=='-') {
    			if(str.length()>1 && str.charAt(1)>='0' && str.charAt(1)<='9') {
    				// ͨ��������ʽ����ɸѡ
    		    	matcher = compile.matcher(str);
    			}else {
    				return 0;
    			}
    		}else {
    			// ��������������ж��Ƿ�Ϊ��Ч�ַ�
    			if(str.charAt(0)>='0' && str.charAt(0)<='9') {
    		    	matcher = compile.matcher(str);
    			}else {
    				// ����У�ַ�������0
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