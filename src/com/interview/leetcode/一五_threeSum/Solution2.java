package com.interview.leetcode.一五_threeSum;
import java.util.*;

/**
 * 枚举优化
 *
 */
class Solution2 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> innerList = null;
        boolean flag = true;
        // 暴力枚举,双重循环 寻找关系式满足: -c = a+b
        for(int i=0; i<nums.length-2; i++){
            for(int j=i+1; j<nums.length-1; j++){
                // 二分查找
                int resultIndex = Arrays.binarySearch(nums, j+1, nums.length, -(nums[i]+nums[j]));
                if(resultIndex>0){
                    innerList = Arrays.asList(nums[i], nums[j], nums[resultIndex]);
                    Collections.sort(innerList);
                    if(result.size() > 0){
                        for(List<Integer> list : result){
                            if(list.equals(innerList)){
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
        return result;
    }
}
