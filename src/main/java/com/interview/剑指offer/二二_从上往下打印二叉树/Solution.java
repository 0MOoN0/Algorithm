package com.interview.剑指offer.二二_从上往下打印二叉树;

import java.util.*;

// BFS
public class Solution {
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		Queue<TreeNode> s = new LinkedList<TreeNode>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (root == null)
			return result;
		s.offer(root);
		// 遍历当前层数的节点
		while (s.size() > 0) {
			int size = s.size();
			for (int i = 0; i < size; i++) {
				// 出队
				TreeNode tn = s.poll();
				result.add(tn.val);
				if (tn.left != null)
					s.offer(tn.left);
				if (tn.right != null)
					s.offer(tn.right);
			}
		}
		return result;
	}
}
