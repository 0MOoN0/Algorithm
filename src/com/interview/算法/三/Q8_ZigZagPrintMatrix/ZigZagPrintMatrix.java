package com.interview.算法.三.Q8_ZigZagPrintMatrix;

/**
 * 之字打印矩阵
 * input: int[][] matrix = { 
				  { 1, 2, 3, 4 }, 
				  { 5, 6, 7, 8 }, 
				  { 9, 10, 11, 12 }, 
				  { 13,14, 15, 16 } 
				  };
	output: 1 2 5 9 6 3 4 7 10 13 14 11 8 12 15 16 
 * @author Peter
 *
 */
public class ZigZagPrintMatrix {
	
	public static void zigZangPrint(int[][] matrix) {
		// 右下角
		int RR = matrix.length-1; // row
		int RC = matrix[0].length-1; //column
		// 从左上角开始移动的指针
		int LTC = 0;	//左上角开始，按行移动，如果LT = RC ,则开始往下移动
		int LTR = 0;	// 行
		int LDC = 0;	//左上角开始，按列移动，如果LD = RR ,则开始往右移动
		int LDR = 0;	// 行
		boolean flag = false;
		while(LTR <= RR) {
			printMatrix(LTC, LTR, LDC, LDR, matrix, flag);
			flag = !flag;
			// 移动左上角的两个指针，注意判断的顺序，左上角的点先判断列是否需要移动，再判断行是否需要移动，左下角则相反，先判断行再判断列
			LTR = LTC == RC ? LTR+1 : LTR;
			LTC = LTC == RC ? LTC : LTC+1;
			LDC = LDR == RR ? LDC+1 : LDC;
			LDR = LDR == RR ? LDR : LDR+1;
		}
	}
	
	public static void printMatrix(int LTC, int LTR, int LDC, int LDR, int[][]matrix, boolean flag) {
		if(flag) {	// 从左往右
			int curC = LDC;
			int curR = LDR;
			while(curC <= LTC && curR >= LTR) {
				System.out.print(matrix[curC++][curR--] + " ");
			}
		}else {		// 从右往左
			int curC = LTC;
			int curR = LTR;
			while(curC >= LDC && curR <= LDR) {
				System.out.print(matrix[curC--][curR++] + " ");
			}
		}
	}
	

	public static void main(String[] args) {
		  int[][] matrix = { 
				  { 1, 2, 3, 4 }, 
				  { 5, 6, 7, 8 }, 
				  { 9, 10, 11, 12 }, 
				  { 13,14, 15, 16 } 
				  };
		  zigZangPrint(matrix);
	}

}
