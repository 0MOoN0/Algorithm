package com.剑指offer_第二版.一二_矩阵中的路径;

class Solution {

    // y
    int m = 0;
    // x
    int n = 0;
    String target = "";
    boolean[][] visited;
    // 定义移动方向xy, 下，左，右，上
    int[][] directions = {{0, 1}, {-1, 0}, {1, 0}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        target = word;
        visited = new boolean[m][n];
        for (int i = 0; i < board.length; i++) {
            for (int i1 = 0; i1 < board[i].length; i1++) {
                if (subExist(board, i1, i, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean subExist(char[][] board, int x, int y, int k) {
        System.out.println(board[y][x]);
        if (board[y][x] != target.charAt(k)) {
            return false;
        } else if (k == target.length() - 1) {
            return true;
        }
        // 记录当前字符的访问状态
        visited[y][x] = true;
        // 遍历移动方向 下，左，右，上
        for (int i = 0; i < directions.length; i++) {
            int newX = x + directions[i][0];
            int newY = y + directions[i][1];
            if (isOk(newX, newY, k + 1) && subExist(board, newX, newY, k + 1)) {
                return true;
            }
        }
        // 回退状态，此路不同
        visited[y][x] = false;
        return false;
    }

    public boolean isOk(int x, int y, int k) {
        if (y < 0 || y >= m || x < 0 || x >= n || k >= target.length() || visited[y][x]) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        char[][] cs = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        char [][] cs = {{'A','A','A','A','A','A'},{'A','A','A','A','A','A'},{'A','A','A','A','A','A'},{'A','A','A','A','A','A'},{'A','A','A','A','A','A'},{'A','A','A','A','A','A'}};
//        String word = "ABCCED";
//        String word = "AFE";
        String word = "AAAAAAAAAAAAAAB";
        boolean result = solution.exist(cs, word);
        System.out.println(result);
    }

}