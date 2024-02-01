package com.leetcode.二六七零_找出不同元素数目差数组;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        // cache[][0]为从左到右，cache[][1]为从右到左
        int[][] cache = new int[nums.length][2];
        Set<Integer> rs = new HashSet<Integer>();
        Set<Integer> ls = new HashSet<Integer>();
        int n = nums.length-1;
        int i = 0;
        while(i < nums.length){
            if(!ls.contains(nums[i])){
                ls.add(nums[i]);
            }
            cache[i][0] = ls.size();
            if(n < nums.length-1 && !rs.contains(nums[n+1])){
                rs.add(nums[n+1]);
            }
            cache[n][1] = rs.size();
            i++;
            n--;
        }
        int [] res = new int[nums.length];
        for(int j=0; j< nums.length; j++){
            res[j] = cache[j][0] - cache[j][1];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {37,37,37,37,33};
        int[] res = solution.distinctDifferenceArray(nums);
        for(int i=0; i< res.length; i++){
            System.out.println(res[i]);
        }
    }

}