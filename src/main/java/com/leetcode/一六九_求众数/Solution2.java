package com.leetcode.一六九_求众数;

// 排序+统计
import java.util.Arrays;
class Solution2 {
    public int majorityElement(int[] nums) {
        // 判断数组长度为1的情况
        if(nums.length==1){
            return nums[0];
        }
        // 结果数组
        int [] result = new int [2];
        // 排序
        Arrays.sort(nums);
        // 遍历，同时统计出现的次数，如果下标发生变化，记录并比较
        int times = 0;
        for(int i=0; i<nums.length; i++){
            times++;
            if(i==nums.length-1 || nums[i]!=nums[i+1]){ 
                // 当前次数加一，比较结果数组
                if(times > result[0]){
                    // 更新结果数组
                    result[0] = times; 
                    result[1] = nums[i];
                    // 初始化次数
                    times = 0;
                }
            }
        }
        return result[1];
    }
}
