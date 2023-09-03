package com.剑指offer_第二版.二六_树的子结构;

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
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (sub(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    public boolean sub(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return sub(A.left, B.left) && sub(A.right, B.right);
    }

}