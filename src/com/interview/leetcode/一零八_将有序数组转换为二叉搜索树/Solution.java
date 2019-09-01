package com.interview.leetcode.һ���_����������ת��Ϊ����������;
/**
 * �������������������������ģ�����õ������鹹���Ķ������ĸ��ڵ����λ���������м��ֵ
 * ������������߲��ֵ��м�ֵ�������������ұ߲��ֵ��м�ֵ
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
        // �жϱ߽�
        if(start>end){
            return null;
        }
        // ��ȡ�м�ֵ
        int index = start + (end-start)/2;
        // �������ڵ�
        TreeNode root = new TreeNode(nums[index]);
        // ������
        root.right = sortArrayToBSTCore(nums, index+1, end);
        // ������
        root.left = sortArrayToBSTCore(nums, start, index-1);
        return root;
    }
    
}