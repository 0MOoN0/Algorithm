package com.剑指offer_第二版.四零_最小的k个数;

import java.util.Arrays;

class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(arr.length==0){
            return arr;
        }
        Arrays.sort(arr);
        int [] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }
}