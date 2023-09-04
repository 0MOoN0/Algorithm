package com.剑指offer_第二版.三六_二叉搜索树与双向链表;

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    Node head, pre;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        dfs(root);
        // 最后节点的处理
        head.left = pre;
        pre.right = head;
        return head;
    }

    public void dfs(Node root) {
        if (root == null) return;
        dfs(root.left);
        if(pre!=null) {
            pre.right = root;
        }else{
            head = root;
        }
        root.left = pre;
        pre = root;
        dfs(root.right);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}


