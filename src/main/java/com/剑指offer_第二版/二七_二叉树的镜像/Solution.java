package com.剑指offer_第二版.二七_二叉树的镜像;

import com.剑指offer_第二版.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if(root==null){
            return null;
        }
        TreeNode node = new TreeNode(root.val);
        node.right = mirrorTree(root.left);
        node.left = mirrorTree(root.right);
        return node;
    }
}