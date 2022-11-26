package com.interview.算法.四.Q3_SuccessorNode;

/**
 * 在二叉树中找到一个节点的后继节点和前继节点，不用遍历整棵树
 * 在二叉树中找到一个节点的后继节点
 * 后继结点：如果一棵二叉树的中序遍历如下： 1、2、3。则2为1的后继，3为2的后继
 * 二叉树某个节点如果有右子树，则后继节点为该节点的右子树的最左边的节点（中序遍历的规律）
 * 二叉树某个节点如果没有右子树，则后继节点为以该节点作为左子树最后一个节点的节点，否则该节点不存在后继
 * 在二叉树中找到一个节点的前继节点
 * 与找后继节点的方法刚好相反
 * @author Peter
 *
 */
public class SuccessorAndPredecessorNode {
	
	/**
	 * 找到后继节点
	 * @param root
	 * @return
	 */
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
	
	/**
	 * 找到前继节点
	 * @param root
	 * @return
	 */
	public static Node findPredecessorNode(Node root) {
		if(root == null) {
			return null;
		}
		// 判断是否有左子树
		if(root.left != null) {		// 如果有左子树，找到左子树最右边的节点
			root = root.left;
			while(root.right != null) {
				root = root.right;
			}
			return root;
		}else {		// 没有左子树，找到第一个右子树指向当前节点或当前节点所在的子树的节点（如案例所示的7的前继）
			Node pre = root.parent;
			while(pre != null && pre.right != root) {
				root = pre;
				pre = pre.parent;
			}
			return pre;
		}
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
		
		System.out.println("//===========findPredecessorNode==========");
		Node test2 = head.left.left;	// 1's pre is null
		System.out.println(test2.value + " next: " + findPredecessorNode(test2));
		test2 = head.left.left.right;
		System.out.println(test2.value + " next: " + findPredecessorNode(test2));
		test2 = head.left;
		System.out.println(test2.value + " next: " + findPredecessorNode(test2));
		test2 = head.left.right;
		System.out.println(test2.value + " next: " + findPredecessorNode(test2));
		test2 = head.left.right.right;
		System.out.println(test2.value + " next: " + findPredecessorNode(test2));
		test2 = head;
		System.out.println(test2.value + " next: " + findPredecessorNode(test2));
		test2 = head.right.left.left;
		System.out.println(test2.value + " next: " + findPredecessorNode(test2));
		test2 = head.right.left;
		System.out.println(test2.value + " next: " + findPredecessorNode(test2));
		test2 = head.right;
		System.out.println(test2.value + " next: " + findPredecessorNode(test2));
		test2 = head.right.right; // 10's next is null
		System.out.println(test2.value + " next: " + findPredecessorNode(test2));		
		
	}

}
