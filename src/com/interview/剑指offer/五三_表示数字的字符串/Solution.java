package com.interview.��ָoffer.����_��ʾ���ֵ��ַ���;
public class Solution {
    public boolean isNumeric(char[] str) {
        String num = new String(str);
        try{
            Double.parseDouble(num);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}