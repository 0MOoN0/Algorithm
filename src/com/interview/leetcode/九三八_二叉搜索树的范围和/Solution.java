package com.interview.leetcode.九三八_二叉搜索树的范围和;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 我们对树进行深度优先搜索，对于当前节点 node，如果 node.val 小于等于 L，那么只需要继续搜索它的右子树；
 * 如果 node.val 大于等于 R，那么只需要继续搜索它的左子树；如果 node.val 在区间 (L, R) 中，则需要搜索它的所有子树。
作者：LeetCode
链接：https://leetcode-cn.com/problems/range-sum-of-bst/solution/er-cha-sou-suo-shu-de-fan-wei-he-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
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
    		// 如果当前值小于最大值，说明可能有比当前更大的值出现，所以往右搜索
    		if(root.val<R) {
    			dfs(root.right, L, R);
    		}
    		// 如果当前值大于最小值，说明可能有比当前更小的值出现，所以往左搜索
    		if(root.val>L) {
    			dfs(root.left, L, R);
    		}
    		
    	}
    	
    	
    	
    }
    
}