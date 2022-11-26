package com.interview.leetcode.三六_有效的数独;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * WA - 只通过部分测试用例-466/504
 * @author Peter
 *
 */
class Solution {
    
    public boolean isValidSudoku(char[][] board) {
        int N = board.length;
        Set<Character> hSet = new LinkedHashSet<Character>();
        Set<Character> zSet = new LinkedHashSet<Character>();
        Set<Character> jSet = new LinkedHashSet<Character>();
        // 横向扫描  纵向扫描
        for(int i=0; i<N; i++){
            for(int j=0;j<N;j++){
                if(board[i][j]!='.' && hSet.contains(board[i][j])){
                    return false;
                }else if(board[i][j]!='.') {
                	hSet.add(board[i][j]);
                }
                if(board[j][i]!='.' && zSet.contains(board[j][i])){
                    return false;
                }else if(board[i][j]!='.') {
                	zSet.add(board[j][i]);
                }
                int boxNum = i / 3 * 3 + j / 3;
                int h = i%3*3 + j % 3;
                if(board[boxNum][h] != '.' && jSet.contains(board[boxNum][h])){
                    return false;
                }else if(board[boxNum][h] != '.') {
                	jSet.add(board[boxNum][h]);
                }
            }
            hSet.clear();
            zSet.clear();
            jSet.clear();
        }
        return true;
    }
}
