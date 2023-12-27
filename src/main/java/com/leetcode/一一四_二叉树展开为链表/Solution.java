package com.leetcode.一一四_二叉树展开为链表;

import com.leetcode.comm.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 *
 * 思路：
 *  最简单的做法：前序遍历二叉树，将遍历序列存储到数组中，然后遍历数组，构建链表
 *
 *  有没有办法不使用额外空间？
 *      1. 访问根节点时，整理根节点的左子树和右子树，将其展开为链表
 *      2. 如果左子树不为空，则将左子树连接到根节点的右子树
 *          2.1 遍历新的右子树，将原右子树连接到新右子树的末尾
 *
 */
class Solution {
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode right = root.right;
        root.right = root.left;
        root.left = null;
        while(root.right!=null){
            root = root.right;
        }
        root.right = right;
    }
}