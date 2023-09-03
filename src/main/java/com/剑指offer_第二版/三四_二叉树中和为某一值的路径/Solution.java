package com.剑指offer_第二版.三四_二叉树中和为某一值的路径;

import com.剑指offer_第二版.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {

    List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> currentList = new ArrayList<Integer>();

    //DFS
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        sub(root, target, 0);
        return res;
    }

    public void sub(TreeNode root, int target, int sum) {
        if (root == null) {
            return;
        }
        currentList.add(root.val);
        if (sum + root.val == target && root.left == null && root.right == null) {
            res.add(new ArrayList<Integer>(currentList));
        }
        sub(root.left, target, sum + root.val);
        sub(root.right, target, sum + root.val);
        currentList.remove(currentList.size() - 1);
    }

}