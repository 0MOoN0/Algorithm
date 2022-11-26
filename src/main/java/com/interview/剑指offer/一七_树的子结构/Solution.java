package com.interview.剑指offer.一七_树的子结构;
/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
解题的总思路为：
1. 判断A树中是否有节点与B树的root节点相同，如果相同则递归对左右子树进行判断
2. 如果A树的root节点与B树的root节点不相同，则对A树的左右节点进行递归判断
总结，先遍历A树的所有节点，找出与B树root节点相同的节点，再递归进行判断
*/
public class Solution {
    // 本题是判断子结构而不是判断子树，也就是说只要root1包含了root2的所有节点即可
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;
        // 判断root1和root2是否为空
        if(root1!=null && root2!=null){
            // 如果不为空，判断两者是否相等
            if(root1.val == root2.val){
                // 对左右子树进行遍历
                result = helper(root1, root2);
            }
            // 如果不相等，将root1的左子树作为根节点进行遍历
            if(!result){
                result = HasSubtree(root1.left, root2);
            }
            // 如果左子树没有能匹配的，将root1的右子树作为根节点进行遍历
            if(!result){
                result = HasSubtree(root1.right, root2);
            }
        }
        return result;
    }
    
    // 递归判断root2是否为root1的子结构
    public boolean helper(TreeNode root1, TreeNode root2){
        // 递归终止条件
        if(root2==null){    // B子树遍历完毕
            return true;
        }
        if(root1==null){    // A树遍历完毕，但B树未遍历完毕
            return false;
        }
        if(root1.val != root2.val){    // 两棵树的节点不相同
            return false;
        }
        // 左右节点递归进行判断
        return helper(root1.left, root2.left) && helper(root1.right, root2.right);
    }
}
