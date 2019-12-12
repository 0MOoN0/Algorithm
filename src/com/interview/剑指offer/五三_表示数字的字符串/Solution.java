package com.interview.剑指offer.五三_表示数字的字符串;
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