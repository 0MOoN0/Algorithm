package com.interview.��ָoffer.����_�������к�Ϊĳһֵ��·��;
import java.util.ArrayList;
/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
import java.util.*;
public class Solution {
    
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    
    
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root==null || root.val>target) return result;
        DFS(new ArrayList<Integer>(), 0, root, target);
        // ����
        if(result.size()>2){
                	Collections.sort(result, new Comparator<ArrayList<Integer>>() {
			@Override
			public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
				// TODO Auto-generated method stub
				return -(o1.size()-o2.size());
			}
		});
        }
        return result;
    }
    
    public void DFS(ArrayList<Integer> conList, int conResult,TreeNode node, int target){
        // �ݹ���ֹ����
        // 1.�ڵ�Ϊ��
        if(node==null) return ;
        
        // 2.�ж��Ƿ�ΪҶ�ӽڵ�
        if(node.left==null && node.right==null && (conResult+=node.val)==target){
            ArrayList<Integer> list = new ArrayList<Integer>(conList);
            list.add(node.val);
            result.add(list);
            return ;
        }
        // �������Ҷ�ӽڵ㣬������������������
        conList.add(node.val);
        conResult+=node.val;
        DFS(conList, conResult, node.left, target);
        DFS(conList, conResult, node.right, target);
        // ����
        conList.remove(conList.size()-1);
        conResult-=node.val;
    }
    
}