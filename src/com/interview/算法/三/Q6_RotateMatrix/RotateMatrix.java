package com.interview.�㷨.��.Q6_RotateMatrix;

/**
 * ˳ʱ��90����ת����
 * @author Peter
 *
 */
public class RotateMatrix {
	
	// ��[LR][LC]��������˳ʱ����ת90��
	public static void rotateMatrix(int [][]matrix, int LR, int LC, int RR, int RC) {
		// ����
		int times = RC-LC;
		for(int i=0; i<times; i++) {
			// ���Ͻ�
			int temp = matrix[LR][LC+i];
			// ���½��滻���Ͻ�
			matrix[LR][LC+i] = matrix[RR-i][LC];
			// ���½��滻���½�
			matrix[RR-i][LC] = matrix[RR][RC-i];
			// ���Ͻ��滻���½�
			matrix[RR][RC-i] = matrix[LR+i][RC];
			// ���Ͻ��滻���Ͻ�
			matrix[LR+i][RC] = temp;
		}
	}
	
	// ��ӡ����
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
		  int RR = matrix.length-1; // ��
		  int RC = matrix[0].length-1; // ��
		  while(LR<RR && LC<RC) {
			  rotateMatrix(matrix,LR++,LC++,RR--,RC--);	// ÿ��תһ�㣬���ϽǺ����½���������������һ�㣬�൱�ڲ����ƽ�
		  }
		  printMatrix(matrix);
	}

}
