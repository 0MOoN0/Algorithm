package com.leetcode.七九_单词搜索;

class Solution {

    boolean [][] path = null;

    public boolean exist(char[][] board, String word) {
        path = new boolean[board.length][board[0].length];
        for(int row=0;row<board.length;row++){
            for(int col=0;col<board[row].length;col++){
                if(search(board, word, col, row, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean search(char[][] board, String word, int col, int row, int index){
        if(board[row][col] != word.charAt(index)){
            return false;
        }
        if(word.length()-1 == index){
            return true;
        }
        path[row][col] = true;
        // 上下左右
        int [][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        // 往下一步移动
        for(int i=0;i<4;i++){
            // 移动
            if(isOk(board, col+directions[i][0], row+directions[i][1])){
                if(search(board, word, col+directions[i][0], row+directions[i][1], index+1)){
                    return true;
                }
            }
        }
        // 回退状态
        path[row][col] = true;
        return false;
    }

    public boolean isOk(char[][] board, int col, int row){
        if(board.length <= row || board[0].length <= col || row<0 || col<0 || path[row][col]){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // board数组：[["C","A","A"],["A","A","A"],["B","C","D"]]
        char[][] board =
                {
                    {'C','A','A'},
                    {'A','A','A'},
                    {'B','C','D'}
                };
        String word = "AAB";
        System.out.println(new Solution().exist(board, word));
    }


}