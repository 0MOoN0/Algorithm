package com.interview.leetcode.一零四_二叉树的最大深度;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 中心思想：
 * 选择左右子树的最大深度
 * 使用递归的方式对左右子树进行遍历，有种类似动态规划的想法，即每一次返回都是当前节点所能到达的最大深度
 * 
 */
class Solution {
	
    public int maxDepth(TreeNode root) {
    	if(root==null) {
    		return 0;
    	}
    	// 左子树的深度
    	int leftDepth = maxDepth(root.left);
    	// 右子树的深度
    	int rightDepth = maxDepth(root.right);
    	// 比较左右子树的深度，选择最大的那个
    	return Math.max(leftDepth, rightDepth)+1;
    }
    
}