package com.interview.��ָoffer.��_�ؽ�������;

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
    	
    	TreeNode root = new TreeNode(0);
    	TreeNode parent = root;
    	int index = pre.length/2;
    	// ¼����ڵ�
    	if(pre.length >0 ) {
    		root = new TreeNode(pre[0]);
    	}
    	int rootIndex = Arrays.binarySearch(in, pre[0]);
    	for(int i=0; i<pre.length; i++) {
    		
    	}
    	return root.left;
    }
    
    private TreeNode BinaryTree(int[] pre, int []in, int start, int end) {
    	
    }
    
}