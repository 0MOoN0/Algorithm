package com.interview.算法.三.Q9_FindNumInSortedMatrix;

/**
 * 在行列都排好序的矩阵中找数
 * 【要求】 时间复杂度为O(N+M)，额外空间复杂度为O(1)。
 * @author Peter
 *
 */
public class FindNumInSortedMatrix {
	
	public static boolean findNum(int [][] matrix, int k) {
		// 左下角
		int RR = matrix.length-1;
		int RC = matrix[0].length-1;
		// 指针
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
