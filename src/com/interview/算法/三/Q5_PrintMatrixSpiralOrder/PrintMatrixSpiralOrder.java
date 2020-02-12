package com.interview.�㷨.��.Q5_PrintMatrixSpiralOrder;

/**
 * ˳ʱ���ӡ����
 * ˼·�����⵽�ڴ�ӡ����ӡһȦ���߼���ɢ����ӡ��������ֻ��Ҫ֪�����ϽǺ����½Ǽ����Ƴ���ӡ�ı߽�
 * �����������ֻ��һ�� / ֻ��һ��
 * @author Peter
 *
 */
public class PrintMatrixSpiralOrder {

	public static void SpiralOrder(int[][] matrix) {
		// ���Ͻ�
		int a = 0; // ��
		int b = 0; // ��
		// ���½�
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
				// ����
				while (curC < d) {
					System.out.print(matrix[curR][curC++] + " ");
				}
				// ����
				while (curR < c) {
					System.out.print(matrix[curR++][curC] + " ");
				}
				// ����
				while (curC > a) {
					System.out.print(matrix[curR][curC--] + " ");
				}
				// ����
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
