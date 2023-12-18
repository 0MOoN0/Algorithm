package com.leetcode.五六_合并区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 1){
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> merged = new ArrayList<int[]>();
        // 遍历intervals，合并覆盖的区间
        for(int i=0;i<intervals.length;i++){
            // 左边界
            int L = intervals[i][0];
            // 右边界
            int R = intervals[i][1];
            int size = merged.size();
            // 当merged列表为空或者列表最后一个区间的右区间小于当前区间的左区间，说明两个区间没有覆盖
           if(size==0 || merged.get(size-1)[1] < L){
               merged.add(new int[]{L, R});
           }else{
               // 发生了区间覆盖，修改merged当前的右区间，可能是merged的右区间大，也可能是当前intervals的右区间大
               merged.get(size-1)[1] =  Math.max(merged.get(size-1)[1],R);
           }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}