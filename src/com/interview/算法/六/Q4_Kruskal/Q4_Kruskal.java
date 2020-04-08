package com.interview.�㷨.��.Q4_Kruskal;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

import com.interview.�㷨.graph.Edge;
import com.interview.�㷨.graph.Graph;
import com.interview.�㷨.graph.Node;

// ��³˹������С���������㷨�����÷�Χ������ͼ
// �����б߰�Ȩ�����򣬱����ߣ����߼��뼯�ϣ�������ɵļ��Ͼ��ǽ��
public class Q4_Kruskal {

	public static class UnionFind {
		private HashMap<Node, Node> fatherMap;
		private HashMap<Node, Integer> sizeMap;

		public UnionFind() {
			fatherMap = new HashMap<Node, Node>();
			sizeMap = new HashMap<Node, Integer>();
		}

		public void makeSet(Collection<Node> nodes) {
			for (Node node : nodes) {
				fatherMap.put(node, node);
				sizeMap.put(node, 1);
			}
		}

		public Node findFather(Node node) {
			Node father = fatherMap.get(node);
			while (node != father) {
				father = findFather(father);
			}
			fatherMap.put(node, father);
			return father;
		}

		public boolean isSameSet(Node a, Node b) {
			return findFather(a) == findFather(b);
		}

		public void union(Node a, Node b) {
			Node Afather = findFather(a);
			Node Bfather = findFather(b);
			if (Afather != Bfather) {
				Integer Asize = sizeMap.get(Afather);
				Integer Bsize = sizeMap.get(Bfather);
				if (Asize >= Bsize) {
					fatherMap.put(Bfather, Afather);
					sizeMap.put(Afather, sizeMap.get(Afather) + Bsize);
				}else {
					fatherMap.put(Afather,Bfather);
					sizeMap.put(Bfather, sizeMap.get(Bfather) + Asize);
				}
			}
		}
	}

	public static void main(String[] args) {

	}
	
	public static Set<Edge> Kruskal(Graph graph) {
		//���鼯�����ڲ鿴�㼯�ϣ���������ڵ���ͬһ�������ڣ�������֮����ͨ
		UnionFind uf = new UnionFind();
		// ��ʼ�����鼯
		uf.makeSet(graph.nodes.values());
		// ���߰���С�����˳������
		PriorityQueue<Edge> queue = new PriorityQueue<Edge>((e1,e2)->e1.weight-e2.weight);
		for(Edge e : graph.edges) {
			queue.offer(e);
		}
		Set<Edge> result = new HashSet<Edge>();
		// �����б߳���
		while(!queue.isEmpty()) {
			Edge edge = queue.poll();
			// �жϱߵ��������Ƿ���ͬһ��������
			if(!uf.isSameSet(edge.from, edge.to)) {
				uf.union(edge.from, edge.to);
				result.add(edge);
			}
		}
		return result;
	}
	

}
