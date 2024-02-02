package com.leetcode.三三七_打家劫舍III;

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
 * 树形动态规划：当前节点能抢到的最大值一共有两种情况nums[2]，1.nums[0]:抢当前节点和孙节点。2.nums[1]:抢子节点
 * 第一种情况：抢当前节点的最大值相当于：抢当前节点+不抢子节点的最大值
 * 第二种情况：不抢当前节点，抢子节点或者不抢子节点的最大值
 * 综合两种情况：当前节点能抢到的最大值 = Math.max(抢当前节点+不抢子节点的最大值，抢子节点或者不抢子节点的最大值)
 */
class Solution3 {
    public int rob(TreeNode root) {
        int []res = robInternal(root);
        return Math.max(res[0],res[1]);
    }

    public int[] robInternal(TreeNode root){
        if(root == null) return new int[2];
        int []res = new int[2];
        int [] left = robInternal(root.left);
        int [] right = robInternal(root.right);
        // 不抢当前节点
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // 抢当前节点
        res[1] = root.val + left[0] + right[0];
        return res;
    }

}