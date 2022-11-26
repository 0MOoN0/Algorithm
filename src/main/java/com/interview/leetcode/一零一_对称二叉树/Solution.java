package com.interview.leetcode.一零一_对称二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断一棵二叉树是否对称
 * 对称:
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * <p>
 * 非递归版本，判断思路与递归版相似，查看树两边节点是否对称
 *
 * @author Leon
 */
public class Solution {

    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        // 根节点入队两次
        queue.offer(root);
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null) {
                continue;
            }
            // 如果左右子树其中一个不对称，返回false
            if (left == null || right == null || left.val != right.val) {
                return false;
            }
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }
}
