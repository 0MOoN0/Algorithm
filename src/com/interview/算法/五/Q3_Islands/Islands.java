package com.interview.算法.五.Q3_Islands;

/**
 * 岛问题 一个矩阵中只有0和1两种值，每个位置都可以和自己的上、下、左、右 四个位置相连，如果有一片1连在一起，这个部分叫做一个岛，求一个
 * 矩阵中有多少个岛？ 举例： 0 0 1 0 1 0 1 1 1 0 1 0 1 0 0 1 0 0 0 0 0 0 0 0 这个矩阵中有三个岛。
 * 使用深搜解决，将岛染色
 * 
 * @author Peter
 *
 */
public class Islands {

	static int size = 0;

	public static void search(int[][] matrix, int curX, int curY, int x, int y) {
		if (isOk(curX, curY, x, y) && matrix[curY][curX] == 1) {
			matrix[curY][curX] = 2;
			search(matrix, curX + 1, curY, x, y); // 向右移动一步
			search(matrix, curX, curY + 1, x, y); // 向下移动一步
			search(matrix, curX - 1, curY, x, y); // 向左移动一步
			search(matrix, curX, curY - 1, x, y); // 向上移动一步
		}
	}

	// 判断坐标是否合法
	public static boolean isOk(int curX, int curY, int x, int y) {
		if (curX >= 0 && curX <= x && curY >= 0 && curY <= y) {
			return true;
		}
		return false;
	}

	//
	public static int isLands(int[][] matrix) {
		int x = matrix[0].length - 1;
		int y = matrix.length - 1;
		for (int i = 0; i <= y; i++) {
			for (int j = 0; j <= x; j++) {
				if (matrix[i][j] == 1) {
					size++;
					search(matrix, j, i, x, y);
				}
			}
		}
		return size;
	}

	public static void main(String[] args) {
		int[][] m1 = {
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
				{ 0, 1, 1, 1, 0, 1, 1, 1, 0 }, 
				{ 0, 1, 1, 1, 0, 0, 0, 1, 0 },
				{ 0, 1, 1, 0, 0, 0, 0, 0, 0 }, 
				{ 0, 0, 0, 0, 0, 1, 1, 0, 0 }, 
				{ 0, 0, 0, 0, 1, 1, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
		System.out.println(isLands(m1));

		size = 0;
		
		int[][] m2 = { 
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
				{ 0, 1, 1, 1, 1, 1, 1, 1, 0 }, 
				{ 0, 1, 1, 1, 0, 0, 0, 1, 0 },
				{ 0, 1, 1, 0, 0, 0, 1, 1, 0 }, 
				{ 0, 0, 0, 0, 0, 1, 1, 0, 0 }, 
				{ 0, 0, 0, 0, 1, 1, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
				};
		System.out.println(isLands(m2));
	}

}
