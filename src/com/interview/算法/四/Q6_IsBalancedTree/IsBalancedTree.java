package com.interview.�㷨.��.Q6_IsBalancedTree;

/**
 * �ж�һ�����Ƿ�Ϊƽ������� ���������ڵ�ĸ߶Ȳ����һ���ƽ�������
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
	 * ��ȡƽ�����нڵ�ĸ߶ȣ����������ƽ�������򷵻ظ����ĸ߶ȣ����򷵻�-1
	 * 
	 * @param root
	 * @param level
	 * @return
	 */
	public static int getHight(Node root) {
		// ����ڵ�Ϊ�գ���ǰ�߶�Ϊ0
		if (root == null) {
			return 0;
		}
		// �������������У��ϴ�߶�+1
		int left = getHight(root.left);
		if(left == -1) {	// �����������ƽ�⣬ֱ�ӷ���-1�������ж�������
			return -1;
		}
		int right = getHight(root.right);
		if(right == -1) {	// �����������ƽ�⣬ֱ�ӷ���-1�������ж����������߶Ȳ�
			return -1;
		}
		if (Math.abs(left - right) > 1) {
			return -1;
		} else {
			return Math.max(left, right) + 1; // �������������ϴ���+1
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
