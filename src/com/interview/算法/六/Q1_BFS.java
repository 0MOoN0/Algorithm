package com.interview.�㷨.��;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import com.interview.�㷨.graph.Node;

public class Q1_BFS {

	// ��ͼ����BFS�������ӵ����ڵ㿪ʼ
	public static void bfs(Node node) {
		if(node == null) {
			return;
		}
		Queue<Node> queue = new LinkedList<Node>();
		Set<Node> sameSet = new HashSet<Node>();
		queue.add(node);
		sameSet.add(node);
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			System.out.println(cur.value);
			for(Node next:cur.nexts) {
				if(!sameSet.contains(next)) {
					queue.offer(next);
					sameSet.add(next);
				}
			}
		}
		
		
	}

	public static void main(String[] args) {

	}

}
