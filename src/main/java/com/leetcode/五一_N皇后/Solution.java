package com.leetcode.五一_N皇后;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * N皇后问题
 * 皇后的攻击范围：左斜，右斜，同列
 * 将棋盘作为一个坐标轴，左斜和右斜为一条斜线
 *   根据 y=kx + c，可以求出 c的值，在这里k的值可能为-1或1，当k=1时表示右斜，k=-1时，表示左斜
 *   左斜：c = y+x;
 *   右斜: c = y-x
 */
class Solution {

    // 定义两个set，用于存放左斜和右斜的c值
    Set<Integer> left = new HashSet<Integer>();
    Set<Integer> right = new HashSet<Integer>();
    // 定义一个结果集
    List<List<String>> result = new ArrayList<List<String>>();
    // 定义一个数组，表示皇后的摆放位置
    int [] queues;
    public List<List<String>> solveNQueens(int n) {
        // 初始化皇后数组
        queues = new int [n];
        Arrays.fill(queues,-1);
        DFS(0, n);
        return result;
    }

    // DFS方法
    public void DFS(int queue, int n){
        // 结束递归
        if(queue >= n){
            // 加入结果集，结束递归
            result.add(printQueue(n));
            return ;
        }
        // 遍历可能存在的摆放位置
        for(int i=0; i<n; i++){
            // 如果当前位置可以摆放
            if(vaild(queue, i)){
                // 摆放皇后，更新左斜线和右斜线，进行下一层循环
                left.add(queue+i);
                right.add(queue-i);
                queues[queue] = i;

                DFS(queue+1, n);

                // 移除条件，进行下一个位置测试
                left.remove(queue+i);
                right.remove(queue-i);
                queues[queue] = -1;
            }
        }
    }

    public boolean vaild(int queue, int i){
        if(left.contains(queue+i) || right.contains(queue-i)){
            return false;
        }
        for(int j=0; j<queues.length; j++){
            if(queues[j] == i){
                return false;
            }else if(queues[j]==-1){
                return true;
            }
        }
        return true;
    }

    public List<String> printQueue(int n){
        List<String> list = new ArrayList<String>(n);
        // 行字符
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<n; i++){
            sb.append(".");
        }
        // 遍历queues
        for(int i=0; i<queues.length; i++){
            // 填充“。”符号
            sb.setCharAt(queues[i],'Q');
            list.add(sb.toString());
            sb.setCharAt(queues[i],'.');
        }
        return list;
    }

}
