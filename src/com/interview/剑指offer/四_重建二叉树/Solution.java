package com.interview.剑指offer.四_重建二叉树;

import java.util.Arrays;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
    	TreeNode root = BinaryTree(pre, 0, pre.length-1, in, 0, pre.length-1);
    	return root;
    }
    
    private TreeNode BinaryTree(int[] pre, int startPre, int endPre, int [] in, int startIn, int endIn) {
    	// 边界判定
    	if(endPre>startPre || endIn>startIn) {
    		return null;
    	}
    	TreeNode root = new TreeNode(pre[startPre]);
    	for(int i=startIn; i<=endIn; i++) {
    		if(in[i]==pre[startPre]) {
    			root.left = BinaryTree(pre, startPre+1, startPre+i-startIn, in, startIn, i-1);
    			root.right = BinaryTree(pre, i-startIn+startPre+1, endPre, in ,i+1, endIn);
    		}
    	}
    	
    	return root;
    }
    
}
