package com.interview.leetcode.������_�����������ķ�Χ��;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * ���Ƕ�����������������������ڵ�ǰ�ڵ� node����� node.val С�ڵ��� L����ôֻ��Ҫ��������������������
 * ��� node.val ���ڵ��� R����ôֻ��Ҫ����������������������� node.val ������ (L, R) �У�����Ҫ������������������
���ߣ�LeetCode
���ӣ�https://leetcode-cn.com/problems/range-sum-of-bst/solution/er-cha-sou-suo-shu-de-fan-wei-he-by-leetcode/
��Դ�����ۣ�LeetCode��
����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������
 */
class Solution {
	
	int ans ;
	
    public int rangeSumBST(TreeNode root, int L, int R) {
        ans = 0;
    	dfs(root, L, R);
    	return ans;
    }
    
    public void dfs(TreeNode root, int L, int R) {
    	if(root!=null) {
    		if(root.val>=L && root.val<=R) {
    			ans += root.val;
    		}
    		// �����ǰֵС�����ֵ��˵�������бȵ�ǰ�����ֵ���֣�������������
    		if(root.val<R) {
    			dfs(root.right, L, R);
    		}
    		// �����ǰֵ������Сֵ��˵�������бȵ�ǰ��С��ֵ���֣�������������
    		if(root.val>L) {
    			dfs(root.left, L, R);
    		}
    		
    	}
    	
    	
    	
    }
    
}