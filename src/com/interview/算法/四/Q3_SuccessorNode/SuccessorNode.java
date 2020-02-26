package com.interview.算法.四.Q3_SuccessorNode;

/**
 * 在二叉树中找到一个节点的后继节点
 * 后继结点：如果一棵二叉树的中序遍历如下： 1、2、3。则2为1的后继，3为2的后继
 * 二叉树某个节点如果有右子树，则后继节点为该节点的右子树的最左边的节点（中序遍历的规律）
 * 二叉树某个节点如果没有右子树，则后继节点为以该节点作为左子树最后一个节点的节点，否则该节点不存在后继
 * @author Peter
 *
 */
public class SuccessorNode {
	
	public static Node findSuccessorNode(Node root) {
		// 有右子树
		if(root != null && root.right != null) {
			root = root.right;
			while(root.left != null) {
				root = root.left;
			}
			return root;
		}else if(root != null){		// 没有右子树
			Node pre = root.parent;
			while(pre != null && pre.left != root) {	// 根节点的parent节点为null
				root = pre;
				pre = pre.parent;
			}
			return pre;
		}
		return null;
	}
	

	public static class Node {
		public int value;
		public Node left;
		public Node right;
		public Node parent;

		public Node(int data) {
			this.value = data;
		}

		@Override
		public String toString() {
			return "Node [value=" + value + "]";
		}
	}
	public static void main(String[] args) {
		Node head = new Node(6);
		head.parent = null;
		head.left = new Node(3);
		head.left.parent = head;
		head.left.left = new Node(1);
		head.left.left.parent = head.left;
		head.left.left.right = new Node(2);
		head.left.left.right.parent = head.left.left;
		head.left.right = new Node(4);
		head.left.right.parent = head.left;
		head.left.right.right = new Node(5);
		head.left.right.right.parent = head.left.right;
		head.right = new Node(9);
		head.right.parent = head;
		head.right.left = new Node(8);
		head.right.left.parent = head.right;
		head.right.left.left = new Node(7);
		head.right.left.left.parent = head.right.left;
		head.right.right = new Node(10);
		head.right.right.parent = head.right;

		Node test = head.left.left;
		System.out.println(test.value + " next: " + findSuccessorNode(test).value);
		test = head.left.left.right;
		System.out.println(test.value + " next: " + findSuccessorNode(test).value);
		test = head.left;
		System.out.println(test.value + " next: " + findSuccessorNode(test).value);
		test = head.left.right;
		System.out.println(test.value + " next: " + findSuccessorNode(test).value);
		test = head.left.right.right;
		System.out.println(test.value + " next: " + findSuccessorNode(test).value);
		test = head;
		System.out.println(test.value + " next: " + findSuccessorNode(test).value);
		test = head.right.left.left;
		System.out.println(test.value + " next: " + findSuccessorNode(test).value);
		test = head.right.left;
		System.out.println(test.value + " next: " + findSuccessorNode(test).value);
		test = head.right;
		System.out.println(test.value + " next: " + findSuccessorNode(test).value);
		test = head.right.right; // 10's next is null
		System.out.println(test.value + " next: " + findSuccessorNode(test));
	}

}
