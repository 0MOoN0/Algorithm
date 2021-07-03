package com.interview.剑指offer.三四_第一个只出现一次的字符;

public class Solution {
    public int FirstNotRepeatingChar(String str) {
        int [] strs = new int[58];
        char[] cs =  str.toCharArray();
        for(int i=0; i<cs.length; i++){
            strs[ 'z'-cs[i] ] +=1;
        }
        for(int i=0; i<cs.length; i++){
            if(strs[ 'z'-cs[i] ] == 1){
                return i;
            }
        }
        return -1;
    }
}
