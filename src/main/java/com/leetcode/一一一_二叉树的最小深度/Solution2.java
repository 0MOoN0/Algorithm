package com.leetcode.一一一_二叉树的最小深度;

import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS 找到第一个叶子节点所在的深度即可
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution2 {
    public int minDepth(TreeNode root) {
        // 判断数据
        if(root == null) return 0;
        // 初始化队列
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        // 根节点入队
        queue.offer(root);
        int level = 0;
        // BFS
        while(!queue.isEmpty()){
            int size = queue.size();
            level ++;
            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                // 判断是否为子节点
                if(node.left == null && node.right == null){
                    return level;
                }
                // 左右子树入队
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right); 
            }
        }
        return level;
    }
}
