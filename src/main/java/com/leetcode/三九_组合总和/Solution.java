package com.leetcode.三九_组合总和;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

    List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<Integer> curList = new ArrayList<Integer>();
        for(int i=0; i<candidates.length; i++){
            // 减枝
            if(candidates[i] <= target){
                curList.clear();
                combination(candidates, i, curList, 0, target);
            }
        }
        return result;
    }

    // DFS
    public void combination(int[] candidates, int index, List<Integer> curList, int sum , int target){
        if(sum + candidates[index] == target){
            curList.add(candidates[index]);
            result.add(new ArrayList(curList));
            // 状态回退
            curList.remove(curList.size()-1);
        }else if(sum + candidates[index] > target){
            // 减枝
            return;
        }else{
            // 如果小于当前目标数字，可以选择重复利用该数字或使用下一个数字
            sum+=candidates[index];
            curList.add(candidates[index]);
            combination(candidates, index, curList, sum, target);
            for(int i=index+1; i<candidates.length; i++){
                combination(candidates, i, curList, sum, target);
            }
            // 回退状态
            sum-=candidates[index];
            curList.remove(curList.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 5};
        System.out.println(new Solution().combinationSum(candidates, 8));
    }
    
}