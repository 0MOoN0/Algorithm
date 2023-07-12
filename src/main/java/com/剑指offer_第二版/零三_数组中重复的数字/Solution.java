package com.剑指offer_第二版.零三_数组中重复的数字;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i : nums){
            if(set.contains(i)){
                return i;
            }
            set.add(i);
        }
        return -1;
    }
}