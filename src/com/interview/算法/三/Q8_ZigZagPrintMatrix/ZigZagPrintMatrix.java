package com.interview.�㷨.��.Q8_ZigZagPrintMatrix;

/**
 * ֮�ִ�ӡ����
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
		// ���½�
		int RR = matrix.length-1; // row
		int RC = matrix[0].length-1; //column
		// �����Ͻǿ�ʼ�ƶ���ָ��
		int LTC = 0;	//���Ͻǿ�ʼ�������ƶ������LT = RC ,��ʼ�����ƶ�
		int LTR = 0;	// ��
		int LDC = 0;	//���Ͻǿ�ʼ�������ƶ������LD = RR ,��ʼ�����ƶ�
		int LDR = 0;	// ��
		boolean flag = false;
		while(LTR <= RR) {
			printMatrix(LTC, LTR, LDC, LDR, matrix, flag);
			flag = !flag;
			// �ƶ����Ͻǵ�����ָ�룬ע���жϵ�˳�����Ͻǵĵ����ж����Ƿ���Ҫ�ƶ������ж����Ƿ���Ҫ�ƶ������½����෴�����ж������ж���
			LTR = LTC == RC ? LTR+1 : LTR;
			LTC = LTC == RC ? LTC : LTC+1;
			LDC = LDR == RR ? LDC+1 : LDC;
			LDR = LDR == RR ? LDR : LDR+1;
		}
	}
	
	public static void printMatrix(int LTC, int LTR, int LDC, int LDR, int[][]matrix, boolean flag) {
		if(flag) {	// ��������
			int curC = LDC;
			int curR = LDR;
			while(curC <= LTC && curR >= LTR) {
				System.out.print(matrix[curC++][curR--] + " ");
			}
		}else {		// ��������
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
