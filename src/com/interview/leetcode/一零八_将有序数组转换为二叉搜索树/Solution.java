package com.interview.leetcode.一零八_将有序数组转换为二叉搜索树;
/**
 * 二叉搜索树的中序遍历是有序的，因此用递增数组构建的二叉树的根节点就是位置在数组中间的值
 * 左子树就是左边部分的中间值，右子树就是右边部分的中间值
 * 
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null || nums.length<=0){
            return null;
        }
        
        return sortArrayToBSTCore(nums, 0, nums.length-1);
    }
    
    public TreeNode sortArrayToBSTCore(int []nums, int start, int end){
        // 判断边界
        if(start>end){
            return null;
        }
        // 获取中间值
        int index = start + (end-start)/2;
        // 创建根节点
        TreeNode root = new TreeNode(nums[index]);
        // 右子树
        root.right = sortArrayToBSTCore(nums, index+1, end);
        // 左子树
        root.left = sortArrayToBSTCore(nums, start, index-1);
        return root;
    }
    
}
