package com.interview.��ָoffer.����_��С��K����;
// 1. ������ҳ���С��k����
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