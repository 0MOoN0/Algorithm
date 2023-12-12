package com.leetcode.四八_旋转图像;

class Solution {
    public void rotate(int[][] matrix) {
        int RL = 0, CL=0;
        int RR=matrix.length-1, CR=matrix[0].length-1;
        while(RL<RR && CL<CR){
            swap(matrix, RL++, CL++,RR--,CR--);
        }
    }

    public void swap(int[][] matrix, int RL, int CL, int RR, int CR){
        int times = RR - RL;
        for(int i=0; i<times; i++){
            int temp = matrix[RL][CL+i];
            matrix[RL][CL+i] = matrix[RR-i][CL];
            matrix[RR-i][CL] = matrix[RR][CR-i];
            matrix[RR][CR-i] = matrix[RL+i][CR];
            matrix[RL+i][CR] = temp;
        }
    }
}