package com.leetcode.九八_验证二叉搜索树;

import java.util.Stack;

/**
 * AC-4ms-递归中序遍历，获取序列后再进行判断
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    Stack<TreeNode> stack = new Stack<TreeNode>();
    int preNum = Integer.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        while(!stack.isEmpty() || root!=null){
            // 左子树不为空，入栈
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 左子树为空，判断值是否比前一个大
            if(root.val <= preNum){
                return false;
            }
            preNum = root.val;
            // 注：判断右子树
            root = root.right;
        }
        return true;
    }

}
