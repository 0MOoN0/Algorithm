package com.interview.leetcode.һ��_threeSum;
import java.util.*;

/**
 * ö���Ż�
 *
 */
class Solution2 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> innerList = null;
        boolean flag = true;
        // ����ö��,˫��ѭ�� Ѱ�ҹ�ϵʽ����: -c = a+b
        for(int i=0; i<nums.length-2; i++){
            for(int j=i+1; j<nums.length-1; j++){
                // ���ֲ���
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