package com.interview.算法.六.Q2_DFS;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import com.interview.算法.graph.Node;

public class Q2_DFS {
	
	// DFS（非递归）
	public static void DFS(Node node) {
		Stack<Node> nodeStack = new Stack<Node>();
		Set<Node> sameSet = new HashSet<Node>();
		nodeStack.push(node);
		sameSet.add(node);
		System.out.println(node.value);	// 打印起始节点
		while(!nodeStack.isEmpty()) {
			Node cur = nodeStack.pop();
			for(Node next : cur.nexts) {
				if(!sameSet.contains(next)) {
					nodeStack.push(cur);	// 先入父节点
					nodeStack.push(next);
					sameSet.add(next);
					System.out.println(next.value);	// 第一次遇见新节点，打印
					break;
				}
			}
		}
	}

	public static void main(String[] args) {

	}

}
