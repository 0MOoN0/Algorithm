package com.interview.算法.六.Q4_Kruskal;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

import com.interview.算法.graph.Edge;
import com.interview.算法.graph.Graph;
import com.interview.算法.graph.Node;

// 克鲁斯卡尔最小生成树的算法，适用范围：无向图
// 将所有边按权重排序，遍历边，将边加入集合，最后生成的集合就是结果
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
		//并查集，用于查看点集合，如果两个节点在同一个集合内，则两点之间连通
		UnionFind uf = new UnionFind();
		// 初始化并查集
		uf.makeSet(graph.nodes.values());
		// 将边按从小到大的顺序排列
		PriorityQueue<Edge> queue = new PriorityQueue<Edge>((e1,e2)->e1.weight-e2.weight);
		for(Edge e : graph.edges) {
			queue.offer(e);
		}
		Set<Edge> result = new HashSet<Edge>();
		// 将所有边出队
		while(!queue.isEmpty()) {
			Edge edge = queue.poll();
			// 判断边的两个点是否在同一个集合内
			if(!uf.isSameSet(edge.from, edge.to)) {
				uf.union(edge.from, edge.to);
				result.add(edge);
			}
		}
		return result;
	}
	

}
