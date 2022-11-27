package com.leetcode.一七四三_从相邻元素队还原数组;

import java.util.*;

/**
 * 使用HashMap
 *
 * @author Leon
 */
public class Solution2 {

    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        // 遍历adjacentPairs，并将其放入map
        for (int i = 0; i < adjacentPairs.length; i++) {
            map.putIfAbsent(adjacentPairs[i][0], new ArrayList<Integer>());     // 如果当前元素在map中不存在，则放入map
            map.putIfAbsent(adjacentPairs[i][1], new ArrayList<Integer>());
            map.get(adjacentPairs[i][0]).add(adjacentPairs[i][1]);
            map.get(adjacentPairs[i][1]).add(adjacentPairs[i][0]);
        }
        // 找到边界元素
        int[] result = new int[adjacentPairs.length + 1];
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() == 1) {
                result[0] = entry.getKey();
                break;
            }
        }
        // 填充第二位元素
        result[1] = map.get(result[0]).get(0);
        // 填充剩余数组
        for (int i = 2; i < adjacentPairs.length + 1; i++) {
            List<Integer> rel = map.get(result[i - 1]);
            result[i] = result[i-2] == rel.get(0) ? rel.get(1) : rel.get(0);
        }
        return result;
    }

}
