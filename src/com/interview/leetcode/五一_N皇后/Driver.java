package com.interview.leetcode.五一_N皇后;

import java.util.List;

public class Driver {

	public static void main(String[] args) {
		Solution s = new Solution();
		List<List<String>> solveNQueens = s.solveNQueens(4);
		System.out.println(solveNQueens);
	}

}
