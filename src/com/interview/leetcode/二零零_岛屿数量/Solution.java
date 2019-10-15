package com.interview.leetcode.������_��������;

/**
 * # DFS-Ⱦɫ-AC-3ms 
 * 1. �����������ڲ�Ϊһ��С��������֮��Ϊ��һ������ 
 * 2. ÿ��һ���µ�С�����ȼ�¼С���������ٽ���С�����ڵ�����'1'��ƽ(��С����ƽ)
 * 
 * @author Peter
 *
 */
class Solution {

	int result = 0;
	int[] vx = { -1, 1, 0, 0 };
	int[] vy = { 0, 0, -1, 1 };

	public int numIslands(char[][] grid) {
		for (int i = 0; i < grid.length; i++) { // ����
			for (int j = 0; j < grid[i].length; j++) { // ����
				if (grid[i][j] == '1') {
					result += 1;
					DFS(grid, j, i);
				}
			}
		}
		return result;
	}

	public void DFS(char[][] grid, int x, int y) {

		// Ⱦɫ
		grid[y][x] = '0';
		for (int i = 0; i < 4; i++) {
			if (valid(grid, x + vx[i], y + vy[i])) {
				DFS(grid, x + vx[i], y + vy[i]);
			}
		}
	}

	// ��֤�Ƿ�Ϸ�
	public boolean valid(char[][] grid, int x, int y) {
		if (x < 0 || y < 0 || x >= grid[0].length || y >= grid.length || grid[y][x] == '0') {
			return false;
		}
		return true;
	}

}