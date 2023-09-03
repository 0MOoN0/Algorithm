package com.剑指offer_第二版.三二_I从上到下打印二叉树;

import com.剑指offer_第二版.TreeNode;

import java.util.*;

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
    public int[] levelOrder(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                continue;
            }
            result.add(node.val);
            queue.offer(node.left);
            queue.offer(node.right);
        }
        int[] array = result.stream().mapToInt(Integer::intValue).toArray();
        return array;
    }
}