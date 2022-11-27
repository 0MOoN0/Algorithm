package com.leetcode.一零零_相同的树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 广度优先
 *
 * @author Leon
 */
public class Solution2 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(p);
        queue.offer(q);
        while (!queue.isEmpty()) {
            TreeNode pNode = queue.poll();
            TreeNode qNode = queue.poll();
            if (pNode == null && qNode == null) {
                continue;
            }
            // 都不为空或者其中一个为空
            if(pNode==null || qNode == null || qNode.val!=pNode.val){
                return false;
            }
            queue.offer(pNode.left);
            queue.offer(qNode.left);
            queue.offer(pNode.right);
            queue.offer(qNode.right);
        }
        return queue.isEmpty();
    }
}
