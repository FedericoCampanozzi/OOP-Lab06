package it.unibo.oop.lab06.generics1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GraphImpl<N> implements Graph<N> {

	private final Set<N> nodes;
	private final List<Set<N>> adiacentList;

	public GraphImpl() {
		this.nodes = new HashSet<>();
		this.adiacentList = new ArrayList<>();
	}

	public GraphImpl(Set<N> nodes, List<Set<N>> adiacentList) {
		this.nodes = nodes;
		this.adiacentList = adiacentList;
	}

	public void addNode(N node) {
		if(this.nodes.add(node)) {
			adiacentList.add( new HashSet<>() );
		}
	}
	
	public void addEdge(N source, N target) {
		int index = 0;
		for(N nodes : nodes) {
			if(nodes.equals(source)) {
				adiacentList.get(index).add(target);
			}
			index++;
		}
	}

	public Set<N> nodeSet() {
		return this.nodes;
	}
	
	public Set<N> linkedNodes(N node) {
		int index = 0;
		for(N nodes : nodes) {
			if(nodes.equals(node)) {
				return adiacentList.get(index);
			}
			index++;
		}
		return null;
	}
	
	public List<N> getPath(N source, N target) {
		return new ArrayList<N>();
	}
	
	public String toString() {
		List<N> nAsList = new ArrayList<>(nodes);
		String ts = "";
		int index = 0;
		for(Set<N> adiacentNodes : this.adiacentList) {
			ts += "[" + nAsList.get(index) + "] -> [ ";
			for(N node : adiacentNodes) {
				ts += node.toString() + ", ";
			}
			ts = ts.substring(0, ts.length() - 2);
			ts += " ]\n";
			index++;
		}
		return ts;
	}

}
