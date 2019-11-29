package com.interview.剑指offer.三九_平衡二叉树;

// 1. 从左右子树最接近叶子结点的部分开始判断，如果左右子树任何一个部分不平衡，则该树不为平衡二叉树
public class Solution {
	public boolean IsBalanced_Solution(TreeNode root) {
		if (root == null)
			return true;
		// 左子树深度
		int left = treeDepth(root.left);
		int right = treeDepth(root.right);
		int depth = left - right;
		if (depth < -1 || depth > 1) {
			return false;
		}
		// 判断左右子树是否平衡
		return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
	}

	public int treeDepth(TreeNode root) {
		if (root == null)
			return 0;
		return Math.max(treeDepth(root.left), treeDepth(root.right)) + 1;
	}

}