package com.leetcode.七八三_二叉搜索树节点最小距离.solution;

public class Solution {
	    TreeNode pre;
	    int min = Integer.MAX_VALUE;
	
	    public int minDiffInBST(TreeNode root) {
	        inorder(root);
	        return min;
	    }
	
	    public void inorder(TreeNode node) {
	        if (node == null)
	            return;
	
	        inorder(node.left);
	        if (pre != null) {
	            min = Math.min(min, node.val - pre.val);
	        }
	        pre = node;
	        inorder(node.right);
	    }
	
}

