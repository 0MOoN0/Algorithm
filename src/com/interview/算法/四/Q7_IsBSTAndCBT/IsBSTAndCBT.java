package com.interview.�㷨.��.Q7_IsBSTAndCBT;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.interview.�㷨.��.Q7_IsBSTAndCBT.IsBSTAndCBT.Node;

/**
 * �ж�һ�����Ƿ����������������ж�һ�����Ƿ�����ȫ������
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
	
	// �ж϶������Ƿ�Ϊ��ȫ��������ʹ�ù�ȱ����ķ�ʽ
	public static boolean isCBT(Node root) {
		if(root == null) {
			return true;
		}
		boolean leafJudge = false;
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			// ������Ϊ�գ���������Ϊ��
			if(node.left == null && node.right != null) {
				return false;
			}else if(!leafJudge && node.left != null && node.right == null) {		// δ����Ҷ�ӽڵ��ж�ģʽ����������Ϊ�գ�������Ϊ��
				leafJudge = true;
			}else if(leafJudge && (node.left != null || node.right != null)) {	// ����Ҷ�ӽڵ�ģʽ���������������Ϊ��
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
	
	
	// �ж��Ƿ��������������������ʱ��������������˳���ǵ�����
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
				// �ж��������Ƿ�Ϊ��
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
