package com.剑指offer_第二版.一三_机器人的运动范围;

class Solution {

    boolean[][] visited;
    // 方向：下，左，上，右
    int[][] directions = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
    int result = 0;
    int mMax = 0;
    int nMax = 0;

    // m行 n列
    public int movingCount(int m, int n, int k) {
        visited = new boolean[m][n];
        mMax = m - 1;
        nMax = n - 1;
        move(0, 0, k);
        return result;
    }

    public void move(int m, int n, int k) {
        System.out.println("m: " + m + "  n:" + n);
        visited[m][n] = true;
        result++;
        for (int i = 0; i < directions.length; i++) {
            int newM = m + directions[i][0];
            int newN = n + directions[i][1];
            if (isOk(newM, newN, k)) {
                move(newM, newN, k);
            }
        }
    }

    public boolean isOk(int m, int n, int k) {
        if (m < 0 || n < 0 || m > mMax || n > nMax || visited[m][n] || !canMove(m, n, k)) {
            return false;
        }
        return true;
    }

    public boolean canMove(int m, int n, int k) {
        int sum = 0;
        while (m > 0 || n > 0) {
            sum = sum + m % 10;
            sum = sum + n % 10;
            m = m / 10;
            n = n / 10;
        }
        return sum <= k;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int i = solution.movingCount(2, 3, 1); // 3
        int i = solution.movingCount(3, 1, 0); // 1
//        int i = solution.movingCount(3, 2, 17);
        System.out.println(i);
    }

}