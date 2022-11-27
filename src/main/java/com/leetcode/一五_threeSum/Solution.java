package com.leetcode.一五_threeSum;

import java.util.*;

/**
 * 超时：311/313测试用例通过
 * 暴力枚举，多重循环
 * @author Peter
 *
 */
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
                                if(list.containsAll(innerList) && innerList.containsAll(list)){
                                    flag = false;
                                    break;
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
