package com.interview.算法.四.Q6_IsBalancedTree;

/**
 * 判断一棵树是否为平衡二叉树 左右子树节点的高度差大于一则非平衡二叉树
 * 
 * @author Peter
 *
 */
public class IsBalancedTree {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}

	public static boolean isBalancedTree(Node root) {
		return getHight(root) != -1;
	}

	/**
	 * 获取平衡树中节点的高度，如果该树是平衡树，则返回该树的高度，否则返回-1
	 * 
	 * @param root
	 * @param level
	 * @return
	 */
	public static int getHight(Node root) {
		// 如果节点为空，当前高度为0
		if (root == null) {
			return 0;
		}
		// 返回左右子树中，较大高度+1
		int left = getHight(root.left);
		if(left == -1) {	// 如果左子树不平衡，直接返回-1，无需判断右子树
			return -1;
		}
		int right = getHight(root.right);
		if(right == -1) {	// 如果右子树不平衡，直接返回-1，无需判断左右子树高度差
			return -1;
		}
		if (Math.abs(left - right) > 1) {
			return -1;
		} else {
			return Math.max(left, right) + 1; // 返回左右子树较大者+1
		}

	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
//		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
//		head.right.left = new Node(6);
//		head.right.right = new Node(7);

		System.out.println(isBalancedTree(head));
	}

}
