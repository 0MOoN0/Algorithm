package com.interview.leetcode.һ����_��������������;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * ����˼�룺
 * ѡ������������������
 * ʹ�õݹ�ķ�ʽ�������������б������������ƶ�̬�滮���뷨����ÿһ�η��ض��ǵ�ǰ�ڵ����ܵ����������
 * 
 */
class Solution {
	
    public int maxDepth(TreeNode root) {
    	if(root==null) {
    		return 0;
    	}
    	// �����������
    	int leftDepth = maxDepth(root.left);
    	// �����������
    	int rightDepth = maxDepth(root.right);
    	// �Ƚ�������������ȣ�ѡ�������Ǹ�
    	return Math.max(leftDepth, rightDepth)+1;
    }
    
}