package com.interview.leetcode.一五_threeSum;
import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> innerList = null;
        boolean flag = true;
        // 暴力枚举
        for(int i=0; i<=nums.length-2; i++){
            for(int j=i+1; j<=nums.length-1; j++){
                for(int k=j+1; k<nums.length; k++){
                    if(nums[i]+nums[j]+nums[k] == 0){
                        innerList = Arrays.asList(nums[i], nums[j], nums[k]);
                        if(result.size() > 0){
                            for(List<Integer> list : result){
                                if(list.containsAll(innerList)){
                                    flag = false;
                                }
                            }                            
                        }
                        if(flag){
                            result.add(innerList);
                        }
                        flag = true;
                    }
                }
            }
        }
        return result;
    }
}