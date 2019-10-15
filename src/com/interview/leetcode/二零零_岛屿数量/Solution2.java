package com.interview.leetcode.二零零_岛屿数量;

import java.util.LinkedList;
import java.util.Queue;

/**
 * # BFS染色-AC-5ms 
 * 1. 进行BFS需要借助队列完成，队列存储一个数据，因此可以将坐标通过计算的方式转换为一个整数 
 * 2. 行坐标 = 整数 / 每行的个数 
 * 3. 列坐标 = 整数 % 每行的个数
 * 
 * @author Peter
 *
 */
class Solution2 {

	int result = 0;
	int[] vx = { -1, 1, 0, 0 };
	int[] vy = { 0, 0, -1, 1 };
	Queue<Integer> queue = new LinkedList<Integer>(); // 存放元素的队列

	public int numIslands(char[][] grid) {
		for (int i = 0; i < grid.length; i++) { // 行数
			for (int j = 0; j < grid[i].length; j++) { // 列数
				if (grid[i][j] == '1') {
					result += 1;
					// 入队操作
					queue.offer(grid[i].length * i + j);
					BFS(grid);
				}
			}
		}
		return result;
	}

	public void BFS(char[][] grid) {
		while (!queue.isEmpty()) {
			// 取出队列元素
			Integer index = queue.poll();
			// 转换坐标-行坐标
			int indexY = index / grid[0].length;
			// 转换坐标-列坐标
			int indexX = index % grid[0].length;
			// 染色
			grid[indexY][indexX] = '0';
			// 移动坐标并进行判断
			for (int i = 0; i < 4; i++) {
				if (valid(grid, indexX + vx[i], indexY + vy[i])) {
					// 转换坐标
					Integer indexNew = grid[0].length * (indexY + vy[i]) + indexX + vx[i];
					if (!queue.contains(indexNew)) {
						queue.offer(indexNew);
					}
				}
			}
		}
	}

	// 验证是否合法
	public boolean valid(char[][] grid, int x, int y) {
		if (x < 0 || y < 0 || x >= grid[0].length || y >= grid.length || grid[y][x] == '0') {
			return false;
		}
		return true;
	}

}