package com.leetcode.二零零_岛屿数量;

/**
 * # DFS-染色-AC-3ms 
 * 1. 上下左右相邻才为一个小岛，除此之外为另一个岛屿 
 * 2. 每到一个新的小岛，先记录小岛个数，再将与小岛相邻的所有'1'填平(将小岛移平)
 * 
 * @author Peter
 *
 */
class Solution {

	int result = 0;
	int[] vx = { -1, 1, 0, 0 };
	int[] vy = { 0, 0, -1, 1 };

	public int numIslands(char[][] grid) {
		for (int i = 0; i < grid.length; i++) { // 行数
			for (int j = 0; j < grid[i].length; j++) { // 列数
				if (grid[i][j] == '1') {
					result += 1;
					DFS(grid, j, i);
				}
			}
		}
		return result;
	}

	public void DFS(char[][] grid, int x, int y) {

		// 染色
		grid[y][x] = '0';
		for (int i = 0; i < 4; i++) {
			if (valid(grid, x + vx[i], y + vy[i])) {
				DFS(grid, x + vx[i], y + vy[i]);
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
