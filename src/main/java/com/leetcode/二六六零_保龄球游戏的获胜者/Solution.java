package com.leetcode.二六六零_保龄球游戏的获胜者;

class Solution {
    public int isWinner(int[] player1, int[] player2) {
        int res1 = 0;
        int p1Ten = -1;
        int res2 = 0;
        int p2Ten = -1;
        for(int i=0;i<player1.length;i++){
            res1 = p1Ten>=0 && i-p1Ten <=2 ? res1+player1[i]*2 : res1 + player1[i];
            res2 = p2Ten>=0 && i-p2Ten <=2 ? res2+player2[i]*2 : res2 + player2[i];
            if(player1[i] == 10){
                p1Ten = i;
            }
            if(player2[i] == 10){
                p2Ten = i;
            }
        }
        return res1 > res2 ? 1 : res1==res2? 0 : 2;
    }
}