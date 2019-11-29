package com.interview.��ָoffer.����_ƽ�������;

// 1. ������������ӽ�Ҷ�ӽ��Ĳ��ֿ�ʼ�жϣ�������������κ�һ�����ֲ�ƽ�⣬�������Ϊƽ�������
public class Solution {
	public boolean IsBalanced_Solution(TreeNode root) {
		if (root == null)
			return true;
		// ���������
		int left = treeDepth(root.left);
		int right = treeDepth(root.right);
		int depth = left - right;
		if (depth < -1 || depth > 1) {
			return false;
		}
		// �ж����������Ƿ�ƽ��
		return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
	}

	public int treeDepth(TreeNode root) {
		if (root == null)
			return 0;
		return Math.max(treeDepth(root.left), treeDepth(root.right)) + 1;
	}

}