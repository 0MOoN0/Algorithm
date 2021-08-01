package com.interview.leetcode.八六三_二叉树中所有距离为K的节点;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 参考leetcode官方题解：DFS + 哈希表
 * 如果是图，则判断target距离为k的节点很简单，但是树无法做到，因为树是不记录父节点的，因此引用哈希表作为补充，
 * 使得DFS可以访问到当前节点的父节点，完成遍历;
 * <p>
 * DFS 需要记录遍历过的节点，在这个带有哈希表结构的树中，只需要记录当前节点的来源节点就可以避免进入遍历过的节点
 *
 * @author Leon
 */
public class Solution {

    // 记录父节点
    Map<Integer, TreeNode> map = new HashMap<Integer, TreeNode>();
    List<Integer> ans = new ArrayList<Integer>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        recordParents(root);
        DFS(target,target,0,k);
        return ans;
    }

    // 记录节点的父节点
    public void recordParents(TreeNode node) {
        if (node.left != null) {
            map.put(node.left.val, node);
            recordParents(node.left);
        }
        if (node.right != null) {
            map.put(node.right.val, node);
            recordParents(node.right);
        }
    }

    public void DFS(TreeNode cur, TreeNode from, int depTh, int k) {
        if (cur == null) {      // 可能的情况：1.长度不够；2. root节点
            return;
        }
        if (depTh == k) {
            ans.add(cur.val);
        }
        if (cur.left != from) {
            DFS(cur.left, cur, depTh + 1, k);
        }
        if (cur.right != from) {
            DFS(cur.right, cur, depTh + 1, k);
        }
        if (map.get(cur.val) != from) {   // 左右节点已经遍历完成，遍历父节点；可以避免重复遍历
            DFS(map.get(cur.val), cur, depTh + 1, k);
        }
    }
}
