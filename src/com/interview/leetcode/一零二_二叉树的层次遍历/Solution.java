package com.interview.leetcode.一零二_二叉树的层次遍历;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root==null) return new ArrayList<List<Integer>>();
        // 结果List
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        // 初始化栈
        Queue<TreeNode> stack  = new LinkedList<TreeNode>();
        stack.offer(root);
        while(!stack.isEmpty()){
            // 计算长度
            int size = stack.size();
            // 存放每层元素
            ArrayList<Integer> innerList = new ArrayList<Integer>(size);
            for(int i=0; i<size; i++){
                // pop元素
                TreeNode num = stack.poll();
                innerList.add(num.val);
                // 将子节点入栈
                if(num.left != null) stack.offer(num.left);
                if(num.right != null) stack.offer(num.right);
            }
            result.add(innerList);
        }
        return result;
    }
}