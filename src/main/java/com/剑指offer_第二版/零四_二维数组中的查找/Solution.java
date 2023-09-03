package com.剑指offer_第二版.零四_二维数组中的查找;

import com.interview.算法.三.Q9_FindNumInSortedMatrix.FindNumInSortedMatrix;

class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length == 0){
            return false;
        }
        // 开始坐标
        int curY = 0;
        int curX = matrix[0].length-1;
        while(curX>=0 && curY<=matrix.length-1){
            if(matrix[curY][curX] == target){
                return true;
            }else if(matrix[curY][curX] < target){
                curY++;
            }else if(matrix[curY][curX] > target){
                curX--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[][] testData = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int[][] testData = {{-5}};
        Solution solution = new Solution();
        boolean result = solution.findNumberIn2DArray(testData, -5);
        System.out.println(result);
    }
}