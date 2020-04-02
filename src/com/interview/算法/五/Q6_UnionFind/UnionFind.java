package com.interview.�㷨.��.Q6_UnionFind;

import java.util.HashMap;
import java.util.List;

/**
 * ���鼯�ṹ
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

		// ��ʼ�����鼯��������ָ���Լ�
		public void makeSet(List<Node> nodes) {
			fatherMap.clear();
			sizeMap.clear();
			for (Node node : nodes) {
				fatherMap.put(node, node);
				sizeMap.put(node, 1);
			}
		}

		// �ҵ������ڵ�ĸ��ڵ�
		private Node findNode(Node node) {
			Node father = fatherMap.get(node);
			if (node != father) { // ֱ���Լ��ҵ��Լ����ݹ����
				father = findNode(father);
			}
			fatherMap.put(node, father);
			return father;
		}

		// �ж������ڵ��Ƿ����
		public boolean isSameSet(Node a, Node b) {
			return findNode(a) == findNode(b);
		}

		// ���������ڵ�
		public void union(Node a, Node b) {
			if (a == null || b == null) {
				return;
			}
			// �ҵ������ڵ�ĸ�Ԫ��
			Node aHead = findNode(a);
			Node bHead = findNode(b);
			if (aHead != bHead) {
				int aSize = sizeMap.get(aHead);
				int bSize = sizeMap.get(bHead);
				if (aSize <= bSize) { // a��b�ϲ�
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
