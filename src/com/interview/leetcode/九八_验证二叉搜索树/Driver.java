package com.interview.leetcode.九八_验证二叉搜索树;

public class Driver {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		Solution s = new Solution();
		s.isValidBST(root);
		
	}

}
