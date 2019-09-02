package com.interview.leetcode.һ��һ_Excel�����к�;
/**
 * ���ݹ��ɣ����Եó���nλ��ֵΪ:26^(n-1)*��ֵ
 * ��ֵ���ַ�ֵ-'A'+1
 * @author Peter
 *
 */
class Solution {
    public int titleToNumber(String s) {
        int pow = s.length()-1;
        int result = 0;
        for(int i=0; i<s.length(); i++){
            // ��ȡ��ǰ�ַ�
            char indexC = s.charAt(i);
            // ��ǰֵ
            int indexI = (indexC-'A'+1);
            result += indexI * Math.pow(26,pow);
            pow--;
        }
        return result;
    }
}