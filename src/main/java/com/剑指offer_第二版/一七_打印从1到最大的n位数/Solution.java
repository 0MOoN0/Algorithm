package com.剑指offer_第二版.一七_打印从1到最大的n位数;

class Solution {
    public int[] printNumbers(int n) {
        int target = (int) Math.pow(10, n) - 1;
        int[]res = new int[target];
        for (int i = 0; i < res.length; i++) {
            res[i] = i+1;
        }
        return res;
    }
}