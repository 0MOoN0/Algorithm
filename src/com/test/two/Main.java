package com.test.two;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
//		int[][] matrix = { { 1, 2, 3, 4 }};
		int[][] matrix = { { 1},{2},{3},{4}};
		Solution s = new Solution();
		ArrayList<Integer> printMatrix = s.printMatrix(matrix);
		System.out.println(printMatrix);
    }
}
