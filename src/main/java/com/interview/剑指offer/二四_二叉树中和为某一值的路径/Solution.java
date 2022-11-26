package com.interview.剑指offer.二四_二叉树中和为某一值的路径;
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
        // 排序
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
        // 递归终止条件
        // 1.节点为空
        if(node==null) return ;
        
        // 2.判断是否为叶子节点
        if(node.left==null && node.right==null && (conResult+=node.val)==target){
            ArrayList<Integer> list = new ArrayList<Integer>(conList);
            list.add(node.val);
            result.add(list);
            return ;
        }
        // 如果不是叶子节点，继续往左右子树搜索
        conList.add(node.val);
        conResult+=node.val;
        DFS(conList, conResult, node.left, target);
        DFS(conList, conResult, node.right, target);
        // 回溯
        conList.remove(conList.size()-1);
        conResult-=node.val;
    }
    
}
