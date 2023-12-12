package com.leetcode.四六_全排列;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> output = new ArrayList<Integer>();
        for(int i : nums){
            output.add(i);
        }
        backtrack(res, output , 0);
        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> output, int i){
        if(i >= output.size()){
            res.add(new ArrayList<Integer>(output));
        }
        // 让当前数与每一个数进行交换
        for(int index=i;index<output.size();index++){
            Collections.swap(output, index, i);
            backtrack(res, output ,i+1);
            Collections.swap(output, index, i);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,3};
        List<List<Integer>> lists = solution.permute(nums);
        System.out.println(lists);
    }


}