package com.interview.算法.五.Q6_UnionFind;

import java.util.HashMap;
import java.util.List;

/**
 * 并查集结构
 * 
 * @author Peter
 *
 */
public class UnionFind {

	public static class Node {
		// whatever you like
	}

	public static class UnionFindSet {
		public HashMap<Node, Node> fatherMap;
		public HashMap<Node, Integer> sizeMap;

		public UnionFindSet() {
			fatherMap = new HashMap<Node, Node>();
			sizeMap = new HashMap<Node, Integer>();
		}

		// 初始化并查集，让他们指向自己
		public void makeSet(List<Node> nodes) {
			fatherMap.clear();
			sizeMap.clear();
			for (Node node : nodes) {
				fatherMap.put(node, node);
				sizeMap.put(node, 1);
			}
		}

		// 找到给定节点的父节点
		private Node findNode(Node node) {
			Node father = fatherMap.get(node);
			if (node != father) { // 直到自己找到自己，递归结束
				father = findNode(father);
			}
			fatherMap.put(node, father);
			return father;
		}

		// 判断两个节点是否相等
		public boolean isSameSet(Node a, Node b) {
			return findNode(a) == findNode(b);
		}

		// 联合两个节点
		public void union(Node a, Node b) {
			if (a == null || b == null) {
				return;
			}
			// 找到两个节点的父元素
			Node aHead = findNode(a);
			Node bHead = findNode(b);
			if (aHead != bHead) {
				int aSize = sizeMap.get(aHead);
				int bSize = sizeMap.get(bHead);
				if (aSize <= bSize) { // a向b合并
					fatherMap.put(aHead, bHead);
					sizeMap.put(bHead, aSize + bSize);
				} else {
					fatherMap.put(bHead, aHead);
					sizeMap.put(aHead, aSize + bSize);
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
