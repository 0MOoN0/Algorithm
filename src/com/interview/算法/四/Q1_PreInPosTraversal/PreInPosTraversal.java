package com.interview.�㷨.��.Q1_PreInPosTraversal;

import java.util.Stack;

import com.interview.�㷨.common.BinaryTreeNode;

/**
 * ���ַ�ʽ����������
 * @author Peter
 *
 */
public class PreInPosTraversal {

	/**
	 * ����������������ݹ鷽ʽ
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
	 * ����������������ݹ鷽ʽ
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
	 * ����������ݹ鷽ʽ
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
	 * ʹ��ջ�ṹ����������������������ջ������������ջ
	 * @param node
	 */
	public static void preOrderUnRecur(BinaryTreeNode node) {
		if(node != null) {
			Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
			stack.push(node);
			while(!stack.isEmpty()) {
				node = stack.pop();
				System.out.println(node);
				// ��������ջ
				if(node.right != null) {
					stack.push(node.right);
				}
				// ��������ջ
				if(node.left != null) {
					stack.push(node.left);
				}
			}
		}
	}
	
	/**
	 * ���������ʹ��һ��ջ��[һ·����������ջ�����������Ϊ�գ���ջ����������ջ]���ظ��˲���
	 * @param node
	 */
	public static void inOrderUnRecur(BinaryTreeNode node) {
		System.out.println("in-order:");
		if(node != null) {
			Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
			while(!stack.isEmpty() || node != null) {
				// �����������Ϊ�գ�һ·��������ѹջ
				if(node != null) {
					stack.push(node);
					node = node.left;
				}else {
					// ���������Ϊ�գ�����ջ��Ԫ�أ���������
					node = stack.pop();
					System.out.println(node);
					node = node.right;
				}
			}
		}
	}
	
	/**
	 * �������������1��ʹ������ջ������Ҫ�����ʱ��ѹ����һ��ջ�����ͳһ���
	 * ���Խ���������ķ�ʽ��ǰ�������һ���Ƚϣ�ǰ�������ѹ������������������ѹ��������ǰ�������ջ�����Ԫ�أ�����������ջ��ѹ����һ��ջ(������������ʵ���˽��м�ڵ���������Ч��)
	 * ջ�Ĺ�����ѹջ�����������ѹջ�������
	 * ����������������ߡ�������ұߡ��������м�
	 * ���������������м䣬�������ߣ�������ұ�
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
				// ����������ջ
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
