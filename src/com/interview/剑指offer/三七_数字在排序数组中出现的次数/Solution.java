package com.interview.��ָoffer.����_���������������г��ֵĴ���;
public class Solution {
    public int GetNumberOfK(int [] array , int k) {
       int result = 0;
        for(int i=0; i<array.length; i++){
            if(array[i]==k){
                result++;
            }
        }
        return result;
    }
}