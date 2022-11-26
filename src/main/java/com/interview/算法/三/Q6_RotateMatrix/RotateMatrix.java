package com.interview.算法.三.Q6_RotateMatrix;

/**
 * 顺时针90度旋转矩阵
 * @author Peter
 *
 */
public class RotateMatrix {
	
	// 将[LR][LC]所在行列顺时针旋转90度
	public static void rotateMatrix(int [][]matrix, int LR, int LC, int RR, int RC) {
		// 次数
		int times = RC-LC;
		for(int i=0; i<times; i++) {
			// 左上角
			int temp = matrix[LR][LC+i];
			// 左下角替换左上角
			matrix[LR][LC+i] = matrix[RR-i][LC];
			// 右下角替换左下角
			matrix[RR-i][LC] = matrix[RR][RC-i];
			// 右上角替换右下角
			matrix[RR][RC-i] = matrix[LR+i][RC];
			// 左上角替换右上角
			matrix[LR+i][RC] = temp;
		}
	}
	
	// 打印矩阵
	public static void printMatrix(int[][] matrix) {
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[i].length; j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		  int[][] matrix = { 
				  { 1, 2, 3, 4 }, 
				  { 5, 6, 7, 8 }, 
				  { 9, 10, 11, 12 }, 
				  { 13,14, 15, 16 } 
				  };
		  int LR=0,LC=0;
		  int RR = matrix.length-1; // 行
		  int RC = matrix[0].length-1; // 列
		  while(LR<RR && LC<RC) {
			  rotateMatrix(matrix,LR++,LC++,RR--,RC--);	// 每旋转一层，左上角和右下角往矩阵中心缩进一层，相当于步步逼近
		  }
		  printMatrix(matrix);
	}

}
