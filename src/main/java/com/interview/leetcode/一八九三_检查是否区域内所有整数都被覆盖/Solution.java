package com.interview.leetcode.一八九三_检查是否区域内所有整数都被覆盖;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 使用差分数组
 *
 * @author Leon
 */
public class Solution {

    public boolean isCovered(int[][] ranges, int left, int right) {
        int[] diff = new int[52];       // right 可能为50，则需要标记的下标为51，因此需要申请52的长度
        for (int i = 0; i < ranges.length; i++) {
            diff[ranges[i][0]]++;
            diff[ranges[i][1]+1]--;
        }
        // 处理差分数组，对差分数组求和
        int [] sum = new int[52];
        for(int i=1;i<sum.length;i++){
            sum[i] = sum[i-1] + diff[i];
        }
        for(int i=left; i<=right; i ++){
            if(sum[i]<=0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        //[[37,49],[5,17],[8,32]]
        int[][] arr = {{37, 49}, {5, 17}, {8, 32}};
        int left = 29;
        int right = 49;
        Solution s = new Solution();
        boolean result = s.isCovered(arr, left, right);
        System.out.println(result);
    }


}
