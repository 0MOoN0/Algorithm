package com.interview.剑指offer.三七_数字在排序数组中出现的次数;
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
