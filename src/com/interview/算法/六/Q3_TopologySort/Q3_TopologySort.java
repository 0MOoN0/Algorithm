package com.interview.算法.六.Q3_TopologySort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.interview.算法.graph.Graph;
import com.interview.算法.graph.Node;

// 拓扑排序，图必须是有向无环图
public class Q3_TopologySort {

	public static List<Node> topologySort(Graph graph) {
		// 遍历节点，记录所有节点的入度和入度为零的节点
		Queue<Node> zeroQueue = new LinkedList<Node>(); // 入度为零的节点
		Map<Node, Integer> inMap = new HashMap<Node, Integer>(); // 节点与入度
		for (Node node : graph.nodes.values()) {
			inMap.put(node, node.in);
			if (node.in == 0) {
				zeroQueue.offer(node);
			}
		}
		// 获取入度为零的节点，删除这个节点，并减少对应节点的入度，删除顺序即为拓扑排序的顺序
		List<Node> result = new ArrayList<Node>();
		while (!zeroQueue.isEmpty()) {
			Node cur = zeroQueue.poll();
			result.add(cur);
			for (Node next : cur.nexts) {
				inMap.put(next, inMap.get(next)-1);	// 入度减一
				if(inMap.get(next) == 0) {
					zeroQueue.add(next);
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}
