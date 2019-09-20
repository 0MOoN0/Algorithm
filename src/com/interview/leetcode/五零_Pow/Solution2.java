package com.interview.leetcode.五零_Pow;
// 分治法-迭代
class Solution2 {
    public double myPow(double x, int n) {
        long N = n;
        if(N < 0){
            x = 1/x;
            N = -N;
        }
        double result = 1;
        double current = x;
        for(long i=N; 0<i; i/=2){
            if(i%2 == 1){
                result = result * current;
            }
            current = current*current;
        }
        return result;
    }
}