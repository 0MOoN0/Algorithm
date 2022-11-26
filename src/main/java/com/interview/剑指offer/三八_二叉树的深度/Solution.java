package com.interview.剑指offer.三八_二叉树的深度;
/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}
*/
// 递归
// 当前节点最长路径 = 左右子树最长路径数+1
public class Solution {
    public int TreeDepth(TreeNode root) {
        if(root==null) return 0;
        return Math.max(TreeDepth(root.left), TreeDepth(root.right))+1;
    }
}
