package com.leetcode.七八_子集;

import java.util.ArrayList;
import java.util.List;

/**
 * 解题思路：回溯
 */
class Solution {

    List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> subRes = new ArrayList<Integer>();
        result.add(new ArrayList<Integer>());
        for(int i=0; i<nums.length; i++){
            dfs(subRes, nums, i);
        }
        return result;
    }

    public void dfs(List<Integer> subRes, int[] nums, int index){
        subRes.add(nums[index]);
        result.add(new ArrayList<Integer>(subRes));
        // 遍历剩余的元素
        for(int i=index+1; i<nums.length; i++){
            dfs(subRes, nums, i);
        }
        subRes.remove(subRes.size()-1);
    }
}