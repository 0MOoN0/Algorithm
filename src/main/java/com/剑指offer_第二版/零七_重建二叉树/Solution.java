package com.剑指offer_第二版.零七_重建二叉树;

import com.剑指offer_第二版.TreeNode;

import java.util.HashMap;
import java.util.Map;

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
    Map<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i],i);
        }
        return subTree(preorder, inorder, 0, inorder.length-1, 0, inorder.length-1);
    }

    public TreeNode subTree(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }
        // 根据前序遍历 构建节点
        TreeNode node = new TreeNode(preorder[preLeft]);
        // 找到根节点在中序遍历中的位置
        int inMid = indexMap.get(node.val);
        // 计算前序遍历左子树的节点距离
        int distances = inMid - inLeft;
        // 构建左子树
        node.left = subTree(preorder, inorder, preLeft + 1, preLeft + distances, inLeft, inMid - 1);
        // 构建右子树
        node.right = subTree(preorder, inorder, preLeft + distances + 1, preRight, inMid + 1, inRight);
        return node;
    }
}