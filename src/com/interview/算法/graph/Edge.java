package com.interview.�㷨.graph;

// �ߵ�����
public class Edge {
	public int weight;	// Ȩ��/����
	public Node from;
	public Node to;

	public Edge(int weight, Node from, Node to) {
		this.weight = weight;
		this.from = from;
		this.to = to;
	}

}