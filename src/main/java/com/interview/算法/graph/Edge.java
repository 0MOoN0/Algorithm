package com.interview.算法.graph;

// 边的描述
public class Edge {
	public int weight;	// 权重/代价
	public Node from;
	public Node to;

	public Edge(int weight, Node from, Node to) {
		this.weight = weight;
		this.from = from;
		this.to = to;
	}

}
