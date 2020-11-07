package it.unibo.oop.lab06.generics1;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Set;

import org.junit.Test;

/**
 *
 */
public final class UseGraph {
	
    @Test
    public void testGraph() {
    	 
    	final Graph<String> g = new GraphImpl<>();
         g.addNode("a");
         g.addNode("b");
         g.addNode("c");
         g.addNode("d");
         g.addNode("e");
         g.addNode("f");
         g.addEdge("a", "b");
         g.addEdge("b", "c");
         g.addEdge("c", "d");
         g.addEdge("d", "e");
         g.addEdge("c", "a");
         g.addEdge("e", "a");
         g.addEdge("f", "e");
         
         assertEquals("List nodeSet() are not equal",g.nodeSet(), Set.of("a","b","c","d","e", "f"));
         assertEquals("List linkedNodes(\"c\") are not equal",g.linkedNodes("c"), Set.of("a","d"));
         assertEquals("List getPath(\"f\", \"e\") are not equal",g.getPath("a", "e"), List.of("a","b","c","d","e"));
    }
}
