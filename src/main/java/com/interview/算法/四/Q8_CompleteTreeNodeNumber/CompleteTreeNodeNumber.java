package com.interview.算法.四.Q8_CompleteTreeNodeNumber;

/**
 * 计算完全二叉树的节点数
 * 高度为L的满二叉树的节点个数为2^L-1
1. 一路左下，可以探测到树的高度
   1. 查看根节点的右子树，如果右子树的高度与左子树的高度相同，则可以求出左子树节点个数，右子树的节点个数可以划分为相同的子问题递归求解
   2. 如果右子树的高度与左子树不同，则右子树一定是一个满二叉树（完全二叉树的定义），可以求出右子树的高度
 * 
 * @author Peter
 *
 */
public class CompleteTreeNodeNumber {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}
	
	public static int completeTreeNodeNumber(Node root) {
		if(root == null) {
			return 0;
		}
		return count(root, 1, mostLeftLevel(root, 1));
	}
	
	/**
	 * 获取root节点的子节点个数
	 * 
	 * @param root			目标节点
	 * @param curLevel		当前节点所在层数
	 * @param maxLevel		当前节点所在的最大层数
	 * @return
	 */
	public static int count(Node root, int curLevel, int maxLevel) {
		if(curLevel == maxLevel) {
			return 1;
		}
		if(mostLeftLevel(root.right, curLevel+1) == maxLevel) {
			return (1 << (maxLevel-curLevel)) + count(root.right, curLevel+1, maxLevel);
		}else {
			return (1 << (maxLevel-curLevel-1)) + count(root.left, curLevel+1, maxLevel);
		}
	}
	
	
	public static int mostLeftLevel(Node root, int level) {
		while(root != null) {
			level++;
			root = root.left;
		}
		return level-1;
	}
	
	
	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.right.left = new Node(6);
		System.out.println(completeTreeNodeNumber(head));
	}

}
