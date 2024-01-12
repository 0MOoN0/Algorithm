package com.leetcode.二三六_二叉树的最近公共祖先;

import com.leetcode.comm.TreeNode;

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

    TreeNode ans = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    public boolean dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return false;
        }
        // 判断节点是否在左子树
        boolean lson = dfs(root.left, p ,q);
        boolean rson = dfs(root.right, p, q);
        if(lson && rson){
            ans = root;
            return true;
        }
        if((root.val == p.val || root.val == q.val) && (lson || rson)){
            ans = root;
            return true;
        }
        // 如果节点不在左子树，又不在右子树，并且当前节点也不是目标节点，返回false，否则返回true
        return lson || rson || root.val==p.val || root.val==q.val;
    }

}