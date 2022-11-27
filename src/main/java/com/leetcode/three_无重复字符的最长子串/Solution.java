package com.leetcode.three_无重复字符的最长子串;
class Solution {
    public int lengthOfLongestSubstring(String s) {
    	char[] arr = s.toCharArray();
    	switch(arr.length) {
    	case 0:
    		return 0;
		case 1:
    		return 1;
    	}
        int begin = 0, end = 1, maxLength = 0, j = 0;
        for(; end<s.length(); end++) {
        	for(j = begin; j<end; j++) {
//        		 出现相等字符，计算长度，end+1，重新定位begin
        		if(arr[end]==arr[j]) {
        			maxLength = maxLength>(end-begin) ? maxLength : end-begin;
        			begin = j+1;
        			break;
        		}
        		
        	}
        }
        maxLength = maxLength>(end-begin) ? maxLength : end-begin;
        return maxLength;
        
/*        do {
        	// 判断当前字符是否在字串内出现过
        	int repeatIndex = childString.indexOf(s.charAt(end)+"");
        	if(repeatIndex != -1) {
        		// 出现过，重新生成字串
        		begin = repeatIndex+1;
//        		end = ++begin;
        		childString.delete(0, repeatIndex+1);
        		continue;
        	}
        	// 没有出现过，加入字串
        	childString.append(s.charAt(end));
        	if(childString.length()>maxLength) {
        		maxLength ++;
        	}
        	end ++;
        }while(end < s.length());
    	return maxLength;*/
    }
}
