package com.interview.leetcode.������_��ת�ַ���;
/**
 * ʹ��˫��ָ���˼�룬��Ҫһ���ַ��Ŀռ俪��
 * һ��ָ��ָ�������ͷ��һ��ָ��ָ�������β�������������ݣ����ƶ���ֱ����ָ�벻С����ָ��
 * @author Peter
 *
 */
class Solution {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length-1;
        while(left < right){
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
            left++;
            right--;
        }
    }

}