package com.interview.算法.四.Q1_PreInPosTraversal;

import java.util.Stack;

import com.interview.算法.common.BinaryTreeNode;

/**
 * 各种方式遍历二叉树
 * @author Peter
 *
 */
public class PreInPosTraversal {

	/**
	 * 先序遍历二叉树，递归方式
	 * @param node
	 */
	public static void preOrderRecur(BinaryTreeNode node) {
		if(node != null) {
			System.out.println(node);
			preOrderRecur(node.left);
			preOrderRecur(node.right);
		}
	}
	
	/**
	 * 中序遍历二叉树，递归方式
	 * @param node
	 */
	public static void inOrderRecur(BinaryTreeNode node) {
		if(node == null) {
			return ;
		}
		inOrderRecur(node.left);
		System.out.println(node);
		inOrderRecur(node.right);
	}
	
	/**
	 * 后序遍历，递归方式
	 * @param node
	 */
	public static void posOrderRecur(BinaryTreeNode node) {
		if(node ==null) {
			return ;
		}
		posOrderRecur(node.left);
		posOrderRecur(node.right);
		System.out.println(node);
	}
	
	/**
	 * 使用栈结构完成先序遍历，右子树先入栈，左子树后入栈
	 * @param node
	 */
	public static void preOrderUnRecur(BinaryTreeNode node) {
		if(node != null) {
			Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
			stack.push(node);
			while(!stack.isEmpty()) {
				node = stack.pop();
				System.out.println(node);
				// 右子树入栈
				if(node.right != null) {
					stack.push(node.right);
				}
				// 左子树入栈
				if(node.left != null) {
					stack.push(node.left);
				}
			}
		}
	}
	
	/**
	 * 中序遍历，使用一个栈，[一路让左子树入栈，如果左子树为空，弹栈，右子树入栈]，重复此操作
	 * @param node
	 */
	public static void inOrderUnRecur(BinaryTreeNode node) {
		System.out.println("in-order:");
		if(node != null) {
			Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
			while(!stack.isEmpty() || node != null) {
				// 如果左子树不为空，一路将左子树压栈
				if(node != null) {
					stack.push(node);
					node = node.left;
				}else {
					// 如果左子树为空，访问栈顶元素，和右子树
					node = stack.pop();
					System.out.println(node);
					node = node.right;
				}
			}
		}
	}
	
	/**
	 * 后序遍历，方法1，使用两个栈，在它要输出的时候压到另一个栈，最后统一输出
	 * 可以将后序遍历的方式与前序遍历做一个比较，前序遍历先压右子树，后续遍历先压左子树；前序遍历弹栈后输出元素，后续遍历弹栈后压入另一个栈(以上两个操作实现了将中间节点后面输出的效果)
	 * 栈的规则：先压栈，后输出；后压栈，先输出
	 * 后序遍历：先输出左边、再输出右边、最后输出中间
	 * 先序遍历：先输出中间，再输出左边，后输出右边
	 * @param noe
	 */
	public static void posOrderUnRecur(BinaryTreeNode node) {
		if(node != null) {
			Stack<BinaryTreeNode> s1 = new Stack<BinaryTreeNode>();
			Stack<BinaryTreeNode> s2 = new Stack<BinaryTreeNode>();
			s1.push(node);
			while(!s1.isEmpty()) {
				node = s1.pop();
				s2.push(node);
				// 左子树先入栈
				if(node.left != null) {
					s1.push(node.left);
				}
				if(node.right != null) {
					s1.push(node.right);
				}
			}
			while(!s2.isEmpty()) {
				System.out.println(s2.pop());
			}
		}
	}
	
	
	public static void main(String[] args) {
		BinaryTreeNode head = new BinaryTreeNode(5);
		head.left = new BinaryTreeNode(3);
		head.right = new BinaryTreeNode(8);
		head.left.left = new BinaryTreeNode(2);
		head.left.right = new BinaryTreeNode(4);
		head.left.left.left = new BinaryTreeNode(1);
		head.right.left = new BinaryTreeNode(7);
		head.right.left.left = new BinaryTreeNode(6);
		head.right.right = new BinaryTreeNode(10);
		head.right.right.left = new BinaryTreeNode(9);
		head.right.right.right = new BinaryTreeNode(11);
//		preOrderRecur(head);
		System.out.println("//==============");
//		inOrderRecur(head);
		System.out.println("//==============");
		posOrderRecur(head);
		System.out.println("//==============");
//		preOrderUnRecur(head);
		System.out.println("//==============");
//		inOrderUnRecur(head);
		posOrderUnRecur(head);
		
	}

}
