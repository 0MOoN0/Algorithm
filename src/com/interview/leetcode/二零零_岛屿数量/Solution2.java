package com.interview.leetcode.������_��������;

import java.util.LinkedList;
import java.util.Queue;

/**
 * # BFSȾɫ-AC-5ms 
 * 1. ����BFS��Ҫ����������ɣ����д洢һ�����ݣ���˿��Խ�����ͨ������ķ�ʽת��Ϊһ������ 
 * 2. ������ = ���� / ÿ�еĸ��� 
 * 3. ������ = ���� % ÿ�еĸ���
 * 
 * @author Peter
 *
 */
class Solution2 {

	int result = 0;
	int[] vx = { -1, 1, 0, 0 };
	int[] vy = { 0, 0, -1, 1 };
	Queue<Integer> queue = new LinkedList<Integer>(); // ���Ԫ�صĶ���

	public int numIslands(char[][] grid) {
		for (int i = 0; i < grid.length; i++) { // ����
			for (int j = 0; j < grid[i].length; j++) { // ����
				if (grid[i][j] == '1') {
					result += 1;
					// ��Ӳ���
					queue.offer(grid[i].length * i + j);
					BFS(grid);
				}
			}
		}
		return result;
	}

	public void BFS(char[][] grid) {
		while (!queue.isEmpty()) {
			// ȡ������Ԫ��
			Integer index = queue.poll();
			// ת������-������
			int indexY = index / grid[0].length;
			// ת������-������
			int indexX = index % grid[0].length;
			// Ⱦɫ
			grid[indexY][indexX] = '0';
			// �ƶ����겢�����ж�
			for (int i = 0; i < 4; i++) {
				if (valid(grid, indexX + vx[i], indexY + vy[i])) {
					// ת������
					Integer indexNew = grid[0].length * (indexY + vy[i]) + indexX + vx[i];
					if (!queue.contains(indexNew)) {
						queue.offer(indexNew);
					}
				}
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