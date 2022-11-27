package com.leetcode.一五_threeSum;
import java.util.*;

/**
 * 双指针-超时
 *
 */
class Solution3 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> innerList = null;
        // 对数组进行排序
        Arrays.sort(nums);
        boolean flag = true;
        // 遍历一次
        for(int i=0; i<nums.length-2; i++){
            // 左右指针
            int j = i+1;
            int k = nums.length-1;
            while(j<k){
                if(nums[i]+nums[j]+nums[k]==0){
                    // 判重
                    innerList = Arrays.asList(nums[i], nums[j], nums[k]);
                    Collections.sort(innerList);
                    if (result.size() > 0){
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
                    k--;
                    j++;
                }else if(nums[i]+nums[j]+nums[k]>0){
                    k--;
                }else if(nums[i]+nums[j]+nums[k]<0){
                    j++;
                }
            }
        }
        return result;
    }
}
