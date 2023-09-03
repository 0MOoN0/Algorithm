package com.剑指offer_第二版.二八_对称的二叉树;

import com.剑指offer_第二版.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return sub(root, root);
    }

    public boolean sub(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if(left==null || right==null || left.val != right.val){
            return false;
        }
        return sub(left.left, right.right) && sub(left.right, right.left);
    }

}