package com.interview.剑指offer.二九_最小的K个数;
// 1. 排序后找出最小的k个数
import java.util.*;
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(k>input.length) return result;
        Arrays.sort(input);
        for(int i=0; i<k; i++){
            if(i==k || i==input.length) return result;
            result.add(input[i]);
        }
        return result;
    }
}
