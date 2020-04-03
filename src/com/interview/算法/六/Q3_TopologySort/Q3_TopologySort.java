package com.interview.�㷨.��.Q3_TopologySort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.interview.�㷨.graph.Graph;
import com.interview.�㷨.graph.Node;

// ��������ͼ�����������޻�ͼ
public class Q3_TopologySort {

	public static List<Node> topologySort(Graph graph) {
		// �����ڵ㣬��¼���нڵ����Ⱥ����Ϊ��Ľڵ�
		Queue<Node> zeroQueue = new LinkedList<Node>(); // ���Ϊ��Ľڵ�
		Map<Node, Integer> inMap = new HashMap<Node, Integer>(); // �ڵ������
		for (Node node : graph.nodes.values()) {
			inMap.put(node, node.in);
			if (node.in == 0) {
				zeroQueue.offer(node);
			}
		}
		// ��ȡ���Ϊ��Ľڵ㣬ɾ������ڵ㣬�����ٶ�Ӧ�ڵ����ȣ�ɾ��˳��Ϊ���������˳��
		List<Node> result = new ArrayList<Node>();
		while (!zeroQueue.isEmpty()) {
			Node cur = zeroQueue.poll();
			result.add(cur);
			for (Node next : cur.nexts) {
				inMap.put(next, inMap.get(next)-1);	// ��ȼ�һ
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
