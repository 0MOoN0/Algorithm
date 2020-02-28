package com.interview.算法.四.Q7_IsBSTAndCBT;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.interview.算法.四.Q7_IsBSTAndCBT.IsBSTAndCBT.Node;

/**
 * 判断一棵树是否是搜索二叉树、判断一棵树是否是完全二叉树
 * @author Peter
 *
 */
public class IsBSTAndCBT {
	
	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}
	
	// 判断二叉树是否为完全二叉树，使用广度遍历的方式
	public static boolean isCBT(Node root) {
		if(root == null) {
			return true;
		}
		boolean leafJudge = false;
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			// 左子树为空，右子树不为空
			if(node.left == null && node.right != null) {
				return false;
			}else if(!leafJudge && node.left != null && node.right == null) {		// 未开启叶子节点判断模式，左子树不为空，右子树为空
				leafJudge = true;
			}else if(leafJudge && (node.left != null || node.right != null)) {	// 开启叶子节点模式，且左或右子树不为空
				return false;
			}
			if(node.left != null) {
				queue.offer(node.left);
			}
			if(node.right != null) {
				queue.offer(node.right);
			}
		}
		return true;
	}
	
	
	// 判断是否搜索二叉树，中序遍历时，搜索二叉树的顺序是递增的
	public static boolean isBST(Node root) {
		if(root == null) {
			return true;
		}
		Node pre = null;
		Stack<Node> s = new Stack<Node>();
		while(!s.isEmpty() || root != null) {
			if(root != null) {
				s.push(root);
				root = root.left;
			}else {
				root = s.pop();
				if(pre == null || pre.value <= root.value) {
					pre = root;
				}else if(pre.value > root.value) {
					return false;
				}
				// 判断右子树是否为空
				root = root.right;
			}
		}
		return true;
	}
	

	public static void main(String[] args) {
		Node head = new Node(4);
		head.left = new Node(2);
		head.right = new Node(6);
		head.left.left = new Node(1);
		head.left.right = new Node(3);
		head.right.left = new Node(5);
		System.out.println(isBST(head));
		System.out.println(isCBT(head));
	}

}
