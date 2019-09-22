package com.interview.leetcode.һ���_�������Ĳ�α���;

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
        // ���List
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        // ��ʼ��ջ
        Queue<TreeNode> stack  = new LinkedList<TreeNode>();
        stack.offer(root);
        while(!stack.isEmpty()){
            // ���㳤��
            int size = stack.size();
            // ���ÿ��Ԫ��
            ArrayList<Integer> innerList = new ArrayList<Integer>(size);
            for(int i=0; i<size; i++){
                // popԪ��
                TreeNode num = stack.poll();
                innerList.add(num.val);
                // ���ӽڵ���ջ
                if(num.left != null) stack.offer(num.left);
                if(num.right != null) stack.offer(num.right);
            }
            result.add(innerList);
        }
        return result;
    }
}