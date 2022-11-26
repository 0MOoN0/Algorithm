package com.interview.剑指offer.一八_二叉树的镜像;
/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    public void Mirror(TreeNode root) {
        if(root == null){
            return ;
        }
        // 交换两个节点
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.right = left;
        root.left = right;
        Mirror(root.left);
        Mirror(root.right);;
    }
}
