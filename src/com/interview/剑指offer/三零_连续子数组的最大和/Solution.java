package com.interview.剑指offer.三零_连续子数组的最大和;

public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        int result = array[0];
        int sum = 0;
        for(int i=0; i<array.length; i++){
            if(sum+array[i] > array[i]){ // 如果加入当前值比当前值更大，则加入当前值
                sum+=array[i];
            }else{
                sum = array[i];  // 如果加入当前值的结果比当前值更小，则直接使用当前值
            }
            result = sum>result ? sum : result;
        }
        return result;
    }
}
