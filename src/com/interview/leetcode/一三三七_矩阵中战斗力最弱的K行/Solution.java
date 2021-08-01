package com.interview.leetcode.一三三七_矩阵中战斗力最弱的K行;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

/**
 * m == mat.length
 * n == mat[i].length
 * 2 <= n, m <= 100
 * 1 <= k <= m
 * matrix[i][j] 不是 0 就是 1
 *
 * @author Leon
 */
public class Solution {

    public int[] kWeakestRows(int[][] mat, int k) {
        int[][] ranges = new int[mat.length][2];
        // 将每一行的坐标和对应的军人数对应到ranges中
        for (int i = 0; i < mat.length; i++) {
            ranges[i][0] = i;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    break;
                }
                ranges[i][1]++;
            }
        }
        Arrays.sort(ranges, Comparator.comparingInt(o -> o[1]));
        return Arrays.stream(ranges).mapToInt(arr -> arr[0]).limit(k).toArray();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][]intput = {{1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}};
        s.kWeakestRows(intput,3);
    }

}
