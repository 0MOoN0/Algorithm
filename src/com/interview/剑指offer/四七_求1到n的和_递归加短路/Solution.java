package com.interview.剑指offer.四七_求1到n的和_递归加短路;
// 递归+短路
public class Solution {
    public int Sum_Solution(int n) {
        int sum = n;
        // 使用短路终止递归
        boolean flag = ((n>0) && (sum+=Sum_Solution(n-1))>0);
        return sum;
    }
}