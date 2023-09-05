package com.剑指offer_第二版.四五_把数组排成最小的数;


import java.util.Arrays;

class Solution {
    // 利用排序的思想
    public String minNumber(int[] nums) {
        // 将数组转为String数组
        String[] strNums = new String[nums.length];
        for (int i = 0; i < strNums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }
        // 排序
        Arrays.sort(strNums, (x, y) -> (x + y).compareToIgnoreCase(y + x));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strNums.length; i++) {
            sb.append(strNums[i]);
        }
        return sb.toString();
    }
}