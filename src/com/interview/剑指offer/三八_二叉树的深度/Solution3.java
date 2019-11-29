package com.interview.剑指offer.三八_二叉树的深度;

// DFS
public class Solution3 {
    int result = 0;
    public int TreeDepth(TreeNode root) {
        DFS(root, 0);
        return result;
    }
    public void DFS(TreeNode root, int level){
        if(root == null) return ;
        result = (level+=1)>result ? level : result;
        DFS(root.left, level);
        DFS(root.right, level);
    }
}