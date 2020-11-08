package it.unibo.oop.lab06.generics1;

import java.util.*;


public class GraphImpl<N> implements Graph<N> {
	
	private final Map<N, Set<N>> graph;

	
	public GraphImpl(Map<N, Set<N>> map) {
		this.graph = map;
	}
	
	public GraphImpl() {
		this(new HashMap<>());
	}
	
	/**
	 * Add a node in the graph
	 * @param node to add in the graph
	 */
	public void addNode(N node) {
		if(node != null && !this.graph.containsKey(node)) {
			this.graph.put(node, new HashSet<>());
		}
	}

	/**
	 * Add an edge in the graph
	 * @param source node in the graph
	 * @param target node in the graph
	 */
	public void addEdge(N source, N target) {
		if(source != null && target != null) {
			this.addNode(source);
			this.graph.get(source).add(target);
		}
	}

	/**
	 * Return the node set of the graph
	 * @return the node set of the graph
	 */
	public Set<N> nodeSet() {
		return this.graph.keySet();
	}
	
	/**
	 * Return all the linked nodes of a source
	 * @return the set of nodes linked to the source
	 */
	public Set<N> linkedNodes(N node) {
		return  this.graph.getOrDefault(node, null);
	}
	
	/**
	 * Return the path between two nodes using the DFS Algorithm
	 * @param source node in the graph
	 * @param target node in the graph
	 * @return the path from source to target
	 */
	public List<N> getPath(N source, N target) {
		
		List<N> outputList = new LinkedList<>();
		DFS(source, target, (LinkedList<N>) outputList, new HashMap<>());
		return outputList;
	}

	private void DFS(N node, N target, LinkedList<N> list, Map<N, Boolean> exploredNodes) {
		
		exploredNodes.put(node, true);
		
		if(!list.contains(target)) {
			list.add(node);
		}
		
		if(node == target) {
			return;
		}
		
		for(N adjacentEdge : this.graph.get(node)) {
			if(!exploredNodes.getOrDefault(adjacentEdge,false)) {
				DFS(adjacentEdge, target, list, exploredNodes);
			}
		}
		
		if(!list.contains(target)) {
			list.removeLast();
		}
	}

	@Override
	public String toString() {
		String s = "";
		for(N nodes : this.graph.keySet()) {
			s+= "[" + nodes + "] -> [ ";
			for(N advList : this.graph.get(nodes)) {
				s+= advList + " ";
			}
			s+="]\n";
		}
		return s;
	}
	
}