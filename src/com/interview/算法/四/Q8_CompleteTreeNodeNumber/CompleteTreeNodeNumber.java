package com.interview.�㷨.��.Q8_CompleteTreeNodeNumber;

/**
 * ������ȫ�������Ľڵ���
 * �߶�ΪL�����������Ľڵ����Ϊ2^L-1
1. һ·���£�����̽�⵽���ĸ߶�
   1. �鿴���ڵ��������������������ĸ߶����������ĸ߶���ͬ�����������������ڵ�������������Ľڵ�������Ի���Ϊ��ͬ��������ݹ����
   2. ����������ĸ߶�����������ͬ����������һ����һ��������������ȫ�������Ķ��壩����������������ĸ߶�
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
	 * ��ȡroot�ڵ���ӽڵ����
	 * 
	 * @param root			Ŀ��ڵ�
	 * @param curLevel		��ǰ�ڵ����ڲ���
	 * @param maxLevel		��ǰ�ڵ����ڵ�������
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
