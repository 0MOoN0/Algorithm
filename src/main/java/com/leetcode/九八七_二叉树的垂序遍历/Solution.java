package com.leetcode.九八七_二叉树的垂序遍历;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * 自定义排序
 * 1. 根据列号排序
 * 2. 列号相同时，根据行号排序
 * 3. 列好行号相同时，根据值大小排序
 *
 * @author Leon
 */
public class Solution {
    // key:
    TreeMap<Integer, List<int[]>> map = new TreeMap<Integer, List<int[]>>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        fillMap(root, 0, 0);
        map.values().forEach(list->list.sort((arr1,arr2)->{
            if(arr1[0]==arr2[0]){
                return arr1[1]-arr2[1];
            }
            return arr1[0]-arr2[0];
        }));
        // 收集元素
        List<List<Integer>> result = map.entrySet().stream().map(entry ->
                entry.getValue().stream().map(arr -> arr[1]).collect(Collectors.toList())
        ).collect(Collectors.toList());
        return result;
    }

    public void fillMap(TreeNode treeNode, int col, int row) {
        if (treeNode == null) {
            return;
        }
        List<int[]> list = map.getOrDefault(col, new ArrayList<int[]>());
        list.add(new int[]{row, treeNode.val});
        map.put(col, list);
        fillMap(treeNode.left, col - 1, row + 1);
        fillMap(treeNode.right, col + 1, row + 1);
    }

}
