package com.interview.leetcode.一一一_二叉树的最小深度;
/**
 * 递归 DFS
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int minDepth(TreeNode root) {
        // 递归结束条件
        if(root == null){
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        // 如果左子树或者右子树为空，则高度为非空左右子树的高度
        // 如果都不为空，则选择高度最小的子树
        return (left==0 || right==0)?(left+right+1):Math.min(left, right)+1;
    }
}
