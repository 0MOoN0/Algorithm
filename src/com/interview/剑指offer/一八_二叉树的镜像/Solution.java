package com.interview.��ָoffer.һ��_�������ľ���;
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
        // ���������ڵ�
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.right = left;
        root.left = right;
        Mirror(root.left);
        Mirror(root.right);;
    }
}