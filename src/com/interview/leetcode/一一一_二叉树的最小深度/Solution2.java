package com.interview.leetcode.һһһ_����������С���;

import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS �ҵ���һ��Ҷ�ӽڵ����ڵ���ȼ���
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution2 {
    public int minDepth(TreeNode root) {
        // �ж�����
        if(root == null) return 0;
        // ��ʼ������
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        // ���ڵ����
        queue.offer(root);
        int level = 0;
        // BFS
        while(!queue.isEmpty()){
            int size = queue.size();
            level ++;
            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                // �ж��Ƿ�Ϊ�ӽڵ�
                if(node.left == null && node.right == null){
                    return level;
                }
                // �����������
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right); 
            }
        }
        return level;
    }
}