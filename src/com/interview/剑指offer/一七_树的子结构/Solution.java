package com.interview.��ָoffer.һ��_�����ӽṹ;
/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
�������˼·Ϊ��
1. �ж�A�����Ƿ��нڵ���B����root�ڵ���ͬ�������ͬ��ݹ���������������ж�
2. ���A����root�ڵ���B����root�ڵ㲻��ͬ�����A�������ҽڵ���еݹ��ж�
�ܽᣬ�ȱ���A�������нڵ㣬�ҳ���B��root�ڵ���ͬ�Ľڵ㣬�ٵݹ�����ж�
*/
public class Solution {
    // �������ж��ӽṹ�������ж�������Ҳ����˵ֻҪroot1������root2�����нڵ㼴��
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;
        // �ж�root1��root2�Ƿ�Ϊ��
        if(root1!=null && root2!=null){
            // �����Ϊ�գ��ж������Ƿ����
            if(root1.val == root2.val){
                // �������������б���
                result = helper(root1, root2);
            }
            // �������ȣ���root1����������Ϊ���ڵ���б���
            if(!result){
                result = HasSubtree(root1.left, root2);
            }
            // ���������û����ƥ��ģ���root1����������Ϊ���ڵ���б���
            if(!result){
                result = HasSubtree(root1.right, root2);
            }
        }
        return result;
    }
    
    // �ݹ��ж�root2�Ƿ�Ϊroot1���ӽṹ
    public boolean helper(TreeNode root1, TreeNode root2){
        // �ݹ���ֹ����
        if(root2==null){    // B�����������
            return true;
        }
        if(root1==null){    // A��������ϣ���B��δ�������
            return false;
        }
        if(root1.val != root2.val){    // �������Ľڵ㲻��ͬ
            return false;
        }
        // ���ҽڵ�ݹ�����ж�
        return helper(root1.left, root2.left) && helper(root1.right, root2.right);
    }
}