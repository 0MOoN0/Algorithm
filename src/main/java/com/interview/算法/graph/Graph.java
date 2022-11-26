package com.interview.算法.graph;

import java.util.HashMap;
import java.util.HashSet;

public class Graph {
	public HashMap<Integer,Node> nodes;
	public HashSet<Edge> edges;

	public Graph() {
		nodes = new HashMap<>();
		edges = new HashSet<>();
	}
}
