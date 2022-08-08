package org.dfpl.lecture.blueprints.practice;

import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.tg.TinkerGraph;

public class Practice17 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Graph g = new TinkerGraph();

		Vertex a = g.addVertex("A");
		Vertex b = g.addVertex("B");
		Vertex c = g.addVertex("C");

		Edge ab = g.addEdge("A|likes|B", a, b, "likes");
		Edge ac = g.addEdge("A|likes|C", a, c, "likes");
		Edge ab2 = g.addEdge("A|loves|B", a, b, "loves");
		Edge cc = g.addEdge("C|likes|C", c, c, "likes");

		a.remove();

		g.getVertices().forEach(System.out::println);
		g.getEdges().forEach(System.out::println);
	}

}
