package com.interview.剑指offer.三一_整数中1出现的次数;
public class Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        // return n;
        char [] cs ; 
        int result = 0;
        for(int i=1; i<=n; i++){
            cs = (i+"").toCharArray();
            for(int j=0; j<cs.length; j++){
                if(cs[j]=='1'){
                    result++;
                }
            }
        }
        return result;
    }
}