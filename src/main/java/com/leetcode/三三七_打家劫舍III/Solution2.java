package com.leetcode.三三七_打家劫舍III;

import com.leetcode.comm.TreeNode;

import java.util.HashMap;
import java.util.Map;

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
 * 记忆化搜索，与暴力搜索的思路类似
 * 1.要么抢当前节点+孙节点，2.要么抢子节点
 *      在第二种情况，抢子节点的过程中，会计算孙节点，与第一种情况抢当前节点+孙节点的情况重复计算了，因此可以将每个节点的计算结果保存起来
 */
class Solution2 {
    Map<TreeNode, Integer> memo = new HashMap<TreeNode, Integer>();
    public int rob(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(memo.get(root) != null){
            return memo.get(root);
        }
        int robGrandSon = root.val;
        if(root.left != null){
            robGrandSon += rob(root.left.left) + rob(root.left.right);
        }
        if(root.right != null){
            robGrandSon += rob(root.right.left) + rob(root.right.right);
        }
        int res = Math.max(robGrandSon, rob(root.left)+rob(root.right));
        memo.put(root, res);
        return res;
    }
}