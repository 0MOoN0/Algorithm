package com.interview.�㷨.common;

/**
 * �������ڵ����ݽṹ
 * 
 * @author Peter
 *
 */
public class BinaryTreeNode {

	public int value;
	public BinaryTreeNode left;
	public BinaryTreeNode right;

	public BinaryTreeNode(int data) {
		this.value = data;
	}

	@Override
	public String toString() {
		return "BinaryTreeNode [value=" + value + "]";
	}

}
