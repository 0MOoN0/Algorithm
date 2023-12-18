package com.leetcode.六四_最小路径和;

class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        dp[0][0] = grid[0][0];
        // 填充第一列的最短路径
        for (int i = 1; i < m; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = grid[0][j] + dp[0][j - 1];
        }
        // 填充dp数组剩下的最短路径
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        // 返回dp左下角的元素，即为最短路径
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
//        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        int[][] grid = {{1, 2}, {1, 1}};
        Solution solution = new Solution();
        System.out.println(solution.minPathSum(grid));
    }

}