package com.leetcode.三三七_打家劫舍III;

import com.leetcode.comm.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution1 {
    // 暴力搜索，要么抢当前节点+孙节点，要么抢子节点
    public int rob(TreeNode root) {
        if(root == null){
            return 0;
        }
        int robGrandSon = root.val;
        if(root.left != null){
            robGrandSon += rob(root.left.left) + rob(root.left.right);

        }
        if(root.right != null){
            robGrandSon += rob(root.right.left) + rob(root.right.right);
        }
        return Math.max(robGrandSon, rob(root.left)+rob(root.right));
    }
}