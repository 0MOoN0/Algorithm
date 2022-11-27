package com.leetcode.一二零_三角形最小路径和;

import java.util.List;

/**
 使用双重循环-AC-6ms
1. 每行的数字都只会使用一次
2. 第(x, y)个数的最小路径 = Min ( (x+1, y) , (x+1, y+1) )
综上，可以不开辟新的空间找出最小路径和，但是会对原数组修改
 * @author Peter
 *
 */
class Solution2 {
    public int minimumTotal(List<List<Integer>> triangle) {
        // 对一行的数字单独判断
        if(triangle.size()==1){
            return triangle.get(0).get(0);
        }
        for(int i=triangle.size()-2; i>=0; i--){
            List<Integer> row = triangle.get(i);
            int col = row.size();

            for(int j=0; j<col; j++){
                int colNum = row.get(j);
                int left = colNum+triangle.get(i+1).get(j);
                int right = colNum+triangle.get(i+1).get(j+1);
                row.set(j, Math.min(left, right));
            }
        } 
        return triangle.get(0).get(0);
    }
}
