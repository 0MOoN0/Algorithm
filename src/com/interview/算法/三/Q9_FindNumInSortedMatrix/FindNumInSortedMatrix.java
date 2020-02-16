package com.interview.�㷨.��.Q9_FindNumInSortedMatrix;

/**
 * �����ж��ź���ľ���������
 * ��Ҫ�� ʱ�临�Ӷ�ΪO(N+M)������ռ临�Ӷ�ΪO(1)��
 * @author Peter
 *
 */
public class FindNumInSortedMatrix {
	
	public static boolean findNum(int [][] matrix, int k) {
		// ���½�
		int RR = matrix.length-1;
		int RC = matrix[0].length-1;
		// ָ��
		int curC = RC;
		int curR = 0;
		while(curC>=0 && curC<=RC && curR>=0 && curR <=RR) {
			if(matrix[curR][curC] < k) {
				curR++;
			}else if(matrix[curR][curC] > k) {
				curC--;
			}else {
				return true;
			}
		}	
		return false;
	}
	

	public static void main(String[] args) {
		  int[][] matrix = { 
				  { 0, 1, 2, 5 }, 
				  { 2, 3, 4, 7 }, 
				  { 4, 4, 4, 8 }, 
				  { 5, 7, 7, 9 } 
				  };
		  System.out.println(findNum(matrix, 9));
		  System.out.println(findNum(matrix, 0));
		  System.out.println(findNum(matrix, 3));
		  System.out.println(findNum(matrix, 10));
		  
	}

}
