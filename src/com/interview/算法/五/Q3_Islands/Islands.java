package com.interview.�㷨.��.Q3_Islands;

/**
 * ������ һ��������ֻ��0��1����ֵ��ÿ��λ�ö����Ժ��Լ����ϡ��¡����� �ĸ�λ�������������һƬ1����һ��������ֽ���һ��������һ��
 * �������ж��ٸ����� ������ 0 0 1 0 1 0 1 1 1 0 1 0 1 0 0 1 0 0 0 0 0 0 0 0 �������������������
 * ʹ�����ѽ��������Ⱦɫ
 * 
 * @author Peter
 *
 */
public class Islands {

	static int size = 0;

	public static void search(int[][] matrix, int curX, int curY, int x, int y) {
		if (isOk(curX, curY, x, y) && matrix[curY][curX] == 1) {
			matrix[curY][curX] = 2;
			search(matrix, curX + 1, curY, x, y); // �����ƶ�һ��
			search(matrix, curX, curY + 1, x, y); // �����ƶ�һ��
			search(matrix, curX - 1, curY, x, y); // �����ƶ�һ��
			search(matrix, curX, curY - 1, x, y); // �����ƶ�һ��
		}
	}

	// �ж������Ƿ�Ϸ�
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
