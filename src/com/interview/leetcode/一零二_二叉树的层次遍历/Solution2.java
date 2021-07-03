package com.interview.leetcode.一零二_二叉树的层次遍历;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归DFS
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution2 {
    // 定义一个结果List
    List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<List<Integer>>();
        DFS(root, 0);
        return result;
    }

    public void DFS(TreeNode node, int level){
        // 递归条件
        if(node == null) return;
        // 将当前结果加入List中
        if(result.size()>level){
            result.get(level).add(node.val);
        }else{
            List<Integer> innerList = new ArrayList<Integer>();
            innerList.add(node.val);
            result.add(innerList);
        }
        // 左子树继续递归
        DFS(node.left, level+1);
        // 右子树继续递归
        DFS(node.right, level+1);
    }
}
