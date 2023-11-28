package com.程序员面试金典_第六版.面试题_01_08_零矩阵;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public void setZeroes(int[][] matrix) {
        int RR = matrix.length-1;
        int RC = matrix[0].length-1;
        List list = new ArrayList();
        // 遍历矩阵，找到为0的元素
        for (int i=0; i<=RC; i++){
            for (int j=0;j<=RR;j++){
                if(matrix[i][j]==0){
                    list.add(new int[]{i,j});
                }
            }
        }
        for(int i=0 ;i<list.size();i++){
            int[] index = (int[])list.get(i);
            fillZero(matrix, index[0], index[1], RR, RC);
        }

    }

    // 将为0的元素所在行和列清零
    public void fillZero(int [][] matrix, int LR, int LC, int RR, int RC){
        // 清零所在行
        for(int j=0;j<=RC;j++){
            matrix[LR][j] = 0;
        }
        // 清零所在列
        for(int i=0; i<=RR; i++){
            matrix[i][LC] = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        int[][] matrix = new int[][]{{1,1,1},{1,0,1},{1,1,1}};
        Solution solution = new Solution();
        solution.setZeroes(matrix);
//        System.in.read();
    }
}