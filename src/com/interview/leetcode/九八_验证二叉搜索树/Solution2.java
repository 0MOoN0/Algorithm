package com.interview.leetcode.�Ű�_��֤����������;
/**
 * �ǵݹ����
 * 
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;
class Solution2 {

    Stack<TreeNode> stack = new Stack<TreeNode>();
    double preNum = -Double.MAX_VALUE;

    public boolean isValidBST(TreeNode root) {
        while(!stack.isEmpty() || root!=null){
            // ��������Ϊ�գ���ջ
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // ������Ϊ�գ��ж�ֵ�Ƿ��ǰһ����
            if(root.val <= preNum){
                return false;
            }
            preNum = root.val;
            // ע���ж�������
            root = root.right;
        }
        return true;
    }

}