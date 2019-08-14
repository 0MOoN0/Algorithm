package com.interview.leetcode.five_������ִ�.solution;

/**
 * ʹ����������չ�㷨�� ���ݻ����ַ�����������Ƴ�����һ���㷨
 * ���ִ������Ŀ�ʼ���α�������������չ�������һ�߲�����������ʾ
 * ע�������������
 *  1. �����ִ���ż��
 *   ��i , i+1 ��Ϊ�α����ߣ�������չ
 *  2. �����ִ�������
 *   ��i��Ϊ�α꣬��������չ
 * 
 * @author Peter
 *
 */
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);    //�����Ӵ��ĳ���Ϊ����ʱ
            int len2 = expandAroundCenter(s, i, i + 1);    //�����Ӵ��ĳ���Ϊż��ʱ
            int len = Math.max(len1, len2);        //ȡ��������е����ֵ
            if (len > end - start) {                //�����������Ϊ��ǰ��������Ӵ�
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }
 
    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;    
        }
        return R - L - 1;
    }
}