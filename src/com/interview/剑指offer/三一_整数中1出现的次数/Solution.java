package com.interview.��ָoffer.��һ_������1���ֵĴ���;
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