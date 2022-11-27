package com.leetcode.一零一_对称二叉树;

/**
 * 双指针
 *      1
 *     / \
 *    2   2
 *  / \ / \
 * 3  4 4  3
 * @author Leon
 */
public class Solution2 {

    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null || left.val != right.val){
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
