package com.interview.算法.common;

/**
 * 二叉树节点数据结构
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
