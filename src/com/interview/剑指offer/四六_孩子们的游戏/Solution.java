package com.interview.剑指offer.四六_孩子们的游戏;
// 使用数组模拟环
// 1. 终止条件：只剩下一个小朋友
// 2. 环中内容不为零时才算有效的一步
public class Solution {
    public int LastRemaining_Solution(int n, int m) {
        int count = n;
        int index = 0;
        int step = 0;
        int [] cycle = new int[n];
        while(count>0){
            if(index>=n){
                index = index%n;
            }
            // 判断当前指针是否有效
            // 有效则index+1, 步数+1
            if(cycle[index] != -1){
                step+=1;
                if(step == m){
                    cycle[index] = -1;
                    count--;
                    // 重置step，从零开始计算
                    step = 0;
                }
            }
            // 无效则index+1,再进行循环
            index+=1;
        }
        return index-1;
    }
}
