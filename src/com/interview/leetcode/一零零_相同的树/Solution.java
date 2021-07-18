package com.interview.leetcode.一零零_相同的树;

/**
 * 判断两棵树是否为相同的树
 * 两棵树上的节点数目都在范围 [0, 100] 内
 * -104 <= Node.val <= 104
 *
 * 深度优先搜索，从左边开始往左探索
 *
 * @author Leon
 */
public class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if ((p != null && q != null) && (p.val == q.val)){
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
        if(p == null && q == null){
            return true;
        }
        return false;
    }

}
