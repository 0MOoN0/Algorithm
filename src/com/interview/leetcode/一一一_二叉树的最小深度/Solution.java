package com.interview.leetcode.һһһ_����������С���;
/**
 * �ݹ� DFS
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
        // �ݹ��������
        if(root == null){
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        // �������������������Ϊ�գ���߶�Ϊ�ǿ����������ĸ߶�
        // �������Ϊ�գ���ѡ��߶���С������
        return (left==0 || right==0)?(left+right+1):Math.min(left, right)+1;
    }
}