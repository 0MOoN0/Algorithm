package com.interview.leetcode.һ���_�������Ĳ�α���;

import java.util.ArrayList;
import java.util.List;

/**
 * �ݹ�DFS
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution2 {
    // ����һ�����List
    List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<List<Integer>>();
        DFS(root, 0);
        return result;
    }

    public void DFS(TreeNode node, int level){
        // �ݹ�����
        if(node == null) return;
        // ����ǰ�������List��
        if(result.size()>level){
            result.get(level).add(node.val);
        }else{
            List<Integer> innerList = new ArrayList<Integer>();
            innerList.add(node.val);
            result.add(innerList);
        }
        // �����������ݹ�
        DFS(node.left, level+1);
        // �����������ݹ�
        DFS(node.right, level+1);
    }
}