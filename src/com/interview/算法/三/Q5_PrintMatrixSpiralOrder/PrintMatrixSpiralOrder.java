package com.interview.算法.三.Q5_PrintMatrixSpiralOrder;

/**
 * 顺时针打印矩阵：
 * 思路：从外到内打印，打印一圈的逻辑扩散到打印整个矩阵，只需要知道左上角和右下角即可推出打印的边界
 * 特殊情况处理：只有一行 / 只有一列
 * @author Peter
 *
 */
public class PrintMatrixSpiralOrder {

	public static void SpiralOrder(int[][] matrix) {
		// 左上角
		int a = 0; // 行
		int b = 0; // 列
		// 右下角
		int d = matrix.length - 1;
		int c = matrix[0].length - 1;
		int curR = a;
		int curC = b;
		if (a == d) {
			while (curC <= c) {
				System.out.print(matrix[curR][curC++] + " ");
			}
		} else if (b == c) {
			while (curR <= d) {
				System.out.print(matrix[curR++][curC] + " ");
			}
		} else {
			while (curR < d && curC < c) {
				// 往右
				while (curC < d) {
					System.out.print(matrix[curR][curC++] + " ");
				}
				// 往下
				while (curR < c) {
					System.out.print(matrix[curR++][curC] + " ");
				}
				// 往左
				while (curC > a) {
					System.out.print(matrix[curR][curC--] + " ");
				}
				// 往上
				while (curR > b) {
					System.out.print(matrix[curR--][curC] + " ");
				}
				d--;
				c--;
				a++;
				b++;
				curR++;
				curC++;
			}
		}

	}

	// for test
	public static void main(String[] args) {
		
		  int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13,
		  14, 15, 16 } };
		 
//		int[][] matrix = { { 1, 2, 3, 4 } };
//		int[][] matrix = { { 1 }, { 2 }, { 3 }, { 4 } };
		SpiralOrder(matrix);
	}

}
