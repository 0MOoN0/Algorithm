package com.interview.leetcode.three_���ظ��ַ�����Ӵ�;
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
//        		 ��������ַ������㳤�ȣ�end+1�����¶�λbegin
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
        	// �жϵ�ǰ�ַ��Ƿ����ִ��ڳ��ֹ�
        	int repeatIndex = childString.indexOf(s.charAt(end)+"");
        	if(repeatIndex != -1) {
        		// ���ֹ������������ִ�
        		begin = repeatIndex+1;
//        		end = ++begin;
        		childString.delete(0, repeatIndex+1);
        		continue;
        	}
        	// û�г��ֹ��������ִ�
        	childString.append(s.charAt(end));
        	if(childString.length()>maxLength) {
        		maxLength ++;
        	}
        	end ++;
        }while(end < s.length());
    	return maxLength;*/
    }
}