package com.leetcode.七八三_二叉搜索树节点最小距离;


/**
 * WA
 * 
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    int ans;
    
    public int minDiffInBST(TreeNode root) {
        ans = Integer.MAX_VALUE;
        dfs(root, ans);
        return ans;
    }
    
    public void dfs(TreeNode root, int val) {
    	if(root!=null) {
    		ans = Math.min(Math.abs(root.val-val),ans);
    		dfs(root.left, root.val);
    		dfs(root.right, root.val);
    	}
    }
    
}
