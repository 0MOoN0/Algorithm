package com.leetcode.一零五_从前序与中序遍历序列构造二叉树;


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
 *
 * 思路：递归
 * 根据preorder数组的第一个元素确定根节点，然后在中序遍历的数组中找到根节点的位置，
 * 然后递归地构造左右子树。
 *    左子树的前序遍历范围：
 *          开始：preStart
 *          结束：中序遍历中，从开始节点到根节点的个数(leftNum)就是前序遍历中，左子树的元素的个数，所以开始节点的范围为：preStart+leftNum
 *    左子树的中序遍历范围：
 *          开始：inStart
 *          结束：根节点的位置
 *    右子树的前序遍历范围：
 *          开始：leftNum+1
 *          结束：preEnd
 *    右子树的中序遍历范围：
 *          开始：根节点的位置
 *          结束：inEnd
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    public TreeNode buildTreeHelper(int[] preorder,int pStart, int pEnd, int[] inorder, int iStart, int iEnd){
        if(pStart == pEnd){
            return null;
        }
        // 前序遍历的第一个节点就是根节点
        TreeNode root = new TreeNode(preorder[pStart]);
        int rIndex = -1;
        // 找到根节点在中序遍历中的位置
        for(int i=iStart; i<iEnd; i++){
            if(inorder[i] == preorder[pStart]){
                rIndex = i;
                break;
            }
        }
        // 左子树的个数
        int leftNum = rIndex - iStart;
        // 构造左右子树
        root.left = buildTreeHelper(preorder, pStart+1, pStart+1+leftNum, inorder, iStart, rIndex);
        root.right = buildTreeHelper(preorder, pStart+1+leftNum, pEnd, inorder, rIndex+1, iEnd);
        return root;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode root = s.buildTree(preorder, inorder);
        System.out.println(root.val);
        System.out.println(root.left.val);
        System.out.println(root.right.val);
        System.out.println(root.left.left.val);
    }
}