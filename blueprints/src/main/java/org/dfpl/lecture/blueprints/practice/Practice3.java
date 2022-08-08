package org.dfpl.lecture.blueprints.practice;

import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.tg.TinkerGraph;

public class Practice3 {

	public static void main(String[] args) {
		Graph g = new TinkerGraph();

		Vertex a = g.addVertex("A");
		Vertex b = g.addVertex("B");
		Vertex c = g.addVertex("C");

		Edge ab = g.addEdge("A|likes|B", a, b, "likes");
		Edge ac = g.addEdge("A|likes|C", a, c, "likes");
		
		System.out.println(ab);
		System.out.println(ac);
	}

}
