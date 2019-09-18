package com.interview.leetcode.�Ű�_��֤����������;

import java.util.ArrayList;
import java.util.List;

/**
 * AC-4ms-�ݹ������������ȡ���к��ٽ����ж�
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        getTheOrder(root, list);
        for(int i=1; i<list.size(); i++){
            if(list.get(i)<=list.get(i-1)){
                return false;
            }
        }
        return true;
    }

    public void getTheOrder(TreeNode root, List<Integer> arr){
        if(root==null){
            return ;
        }
        getTheOrder(root.left, arr);
        arr.add(root.val);
        getTheOrder(root.right, arr);
        // int l = getTheOrder(root.left);
        // arr.add(l);
        // arr.add(root.val);
        // int r = getTheOrder(root.right);
        // arr.add(r);
        // return root.val;
    }

}