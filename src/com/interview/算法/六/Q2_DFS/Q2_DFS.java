package com.interview.�㷨.��.Q2_DFS;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import com.interview.�㷨.graph.Node;

public class Q2_DFS {
	
	// DFS���ǵݹ飩
	public static void DFS(Node node) {
		Stack<Node> nodeStack = new Stack<Node>();
		Set<Node> sameSet = new HashSet<Node>();
		nodeStack.push(node);
		sameSet.add(node);
		System.out.println(node.value);	// ��ӡ��ʼ�ڵ�
		while(!nodeStack.isEmpty()) {
			Node cur = nodeStack.pop();
			for(Node next : cur.nexts) {
				if(!sameSet.contains(next)) {
					nodeStack.push(cur);	// ���븸�ڵ�
					nodeStack.push(next);
					sameSet.add(next);
					System.out.println(next.value);	// ��һ�������½ڵ㣬��ӡ
					break;
				}
			}
		}
	}

	public static void main(String[] args) {

	}

}
