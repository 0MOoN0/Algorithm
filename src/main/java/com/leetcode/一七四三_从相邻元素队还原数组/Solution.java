package com.leetcode.一七四三_从相邻元素队还原数组;

import java.util.*;

/**
 * 超时
 *
 * @author Leon
 */
public class Solution {

    public int[] restoreArray(int[][] adjacentPairs) {
        List<Integer> list = new LinkedList<Integer>();
        Set<Integer> set = new HashSet<Integer>();
        int first = adjacentPairs[0][0];
        int second = adjacentPairs[0][1];
        list.add(first);
        list.add(second);
        set.add(0);
        while (list.size() != adjacentPairs.length + 1) {
            for(int i=1;i<adjacentPairs.length;i++){
                if(set.contains(i)){
                    continue;
                }else if(adjacentPairs[i][0]==first || adjacentPairs[i][1]==first){
                    first = adjacentPairs[i][1]==first?adjacentPairs[i][0]:adjacentPairs[i][1];
                    list.add(0,first);
                    set.add(i);
                    i = 1;
                }else if(adjacentPairs[i][0]==second || adjacentPairs[i][1]==second){
                    second = adjacentPairs[i][1]==second?adjacentPairs[i][0]:adjacentPairs[i][1];
                    list.add(second);
                    set.add(i);
                    i = 1;
                }
            }
        }
        return list.stream().mapToInt(x->x).toArray();
    }

    public static void main(String[] args) {
        int [][]input = {{2,1},{3,4},{3,2}};
        Solution s = new Solution();
        Arrays.stream(s.restoreArray(input)).forEach(System.out::print);
    }

}
