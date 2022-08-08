package org.dfpl.lecture.blueprints.assignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.dfpl.lecture.blueprints.memory.InMemoryGraph;

import com.tinkerpop.blueprints.revised.Direction;
import com.tinkerpop.blueprints.revised.Edge;
import com.tinkerpop.blueprints.revised.Graph;
import com.tinkerpop.blueprints.revised.Vertex;

public class SmallDataTest {

	public static String isEvenTag = "isEven";

	public static void main(String[] args) throws IOException {

		BufferedReader r = new BufferedReader(new FileReader("e:\\email.txt"));

		Graph g = new InMemoryGraph();
		r.lines().forEach(line -> {
			if (line.startsWith("#"))
				return;
			String[] arr = line.split("\t");
			Vertex v1 = g.addVertex(arr[0]);
			int v1Int = Integer.parseInt(v1.getId());
			Vertex v2 = g.addVertex(arr[1]);
			int v2Int = Integer.parseInt(v2.getId());
			Edge e12 = g.addEdge(v1, v2, "l");
			e12.setProperty(isEvenTag, ((v1Int + v2Int) % 2 == 0));
			e12.setProperty("add", v1Int + v2Int);
			e12.setProperty("sub", v1Int - v2Int);
			e12.setProperty("div", (v1Int / (double) v2Int));
		});

		r.close();

		System.out.println("[1] " + g.getVertices().size());
		System.out.println("[2] " + g.getEdges().size());
		System.out.println("[3] " + g.getEdges(isEvenTag, true).size());
		System.out.println("[4] " + g.getEdges(isEvenTag, false).size());
		System.out.println("[5] " + g.getVertex("83").getVertices(Direction.OUT).size());
		System.out.println("[6] " + g.getVertex("30").getVertices(Direction.IN).size());

		System.out.println("[7] " + g.getVertex("83").getVertices(Direction.OUT).stream()
				.flatMap(v -> v.getVertices(Direction.OUT).stream()).toList().size());
		System.out.println("[8] " + g.getVertex("30").getVertices(Direction.IN).stream()
				.flatMap(v -> v.getVertices(Direction.IN).stream()).toList().size());
		System.out.println("[9] " + g.getVertex("83").getVertices(Direction.OUT, isEvenTag, true).stream()
				.flatMap(v -> v.getVertices(Direction.OUT, isEvenTag, false).stream()).toList().size());
		System.out.println("[10] " + g.getVertex("30").getVertices(Direction.IN, isEvenTag, true).stream()
				.flatMap(v -> v.getVertices(Direction.IN, isEvenTag, false).stream()).toList().size());
		System.out.println("[11] " + g.getVertex("83").getVertices(Direction.OUT).stream()
				.flatMap(v -> v.getVertices(Direction.OUT).stream()).flatMap(v -> v.getVertices(Direction.OUT).stream())
				.toList().size());
		System.out.println("[12] " + g.getVertex("30").getVertices(Direction.IN).stream()
				.flatMap(v -> v.getVertices(Direction.IN).stream()).flatMap(v -> v.getVertices(Direction.IN).stream())
				.toList().size());

		long min7 = Long.MAX_VALUE;
		for (int i = 0; i < 10; i++) {
			long pre = System.currentTimeMillis();
			g.getVertex("83").getVertices(Direction.OUT).stream().flatMap(v -> v.getVertices(Direction.OUT).stream())
					.toList().size();
			long elapsedTime = System.currentTimeMillis() - pre;
			if (elapsedTime < min7) {
				min7 = elapsedTime;
				System.out.println("\t" + Long.MAX_VALUE + " -> " + min7);
			}
		}
		System.out.println("[P1] " + min7);

		long min8 = Long.MAX_VALUE;
		for (int i = 0; i < 10; i++) {
			long pre = System.currentTimeMillis();
			g.getVertex("30").getVertices(Direction.IN).stream().flatMap(v -> v.getVertices(Direction.IN).stream())
					.toList().size();
			long elapsedTime = System.currentTimeMillis() - pre;
			if (elapsedTime < min8) {
				min8 = elapsedTime;
				System.out.println("\t" + Long.MAX_VALUE + " -> " + min8);
			}
		}
		System.out.println("[P2] " + min8);

		long min9 = Long.MAX_VALUE;
		for (int i = 0; i < 10; i++) {
			long pre = System.currentTimeMillis();
			g.getVertex("83").getVertices(Direction.OUT, isEvenTag, true).stream()
					.flatMap(v -> v.getVertices(Direction.OUT, isEvenTag, false).stream()).toList().size();
			long elapsedTime = System.currentTimeMillis() - pre;
			if (elapsedTime < min9) {
				min9 = elapsedTime;
				System.out.println("\t" + Long.MAX_VALUE + " -> " + min9);
			}
		}
		System.out.println("[P3] " + min9);

		long min10 = Long.MAX_VALUE;
		for (int i = 0; i < 10; i++) {
			long pre = System.currentTimeMillis();
			g.getVertex("30").getVertices(Direction.IN, isEvenTag, true).stream()
					.flatMap(v -> v.getVertices(Direction.IN, isEvenTag, false).stream()).toList().size();
			long elapsedTime = System.currentTimeMillis() - pre;
			if (elapsedTime < min10) {
				min10 = elapsedTime;
				System.out.println("\t" + Long.MAX_VALUE + " -> " + min10);
			}
		}
		System.out.println("[P4] " + min10);

		long min11 = Long.MAX_VALUE;
		for (int i = 0; i < 5; i++) {
			long pre = System.currentTimeMillis();
			g.getVertex("83").getVertices(Direction.OUT).stream().flatMap(v -> v.getVertices(Direction.OUT).stream())
					.flatMap(v -> v.getVertices(Direction.OUT).stream()).toList().size();
			long elapsedTime = System.currentTimeMillis() - pre;
			if (elapsedTime < min11) {
				min11 = elapsedTime;
				System.out.println("\t" + Long.MAX_VALUE + " -> " + min11);
			}
		}
		System.out.println("[P5] " + min11);

		long min12 = Long.MAX_VALUE;
		for (int i = 0; i < 5; i++) {
			long pre = System.currentTimeMillis();
			g.getVertex("30").getVertices(Direction.IN).stream().flatMap(v -> v.getVertices(Direction.IN).stream())
					.flatMap(v -> v.getVertices(Direction.IN).stream()).toList().size();
			long elapsedTime = System.currentTimeMillis() - pre;
			if (elapsedTime < min12) {
				min12 = elapsedTime;
				System.out.println("\t" + Long.MAX_VALUE + " -> " + min12);
			}
		}
		System.out.println("[P6] " + min12);
	}

	@SuppressWarnings("unused")
	private static void scanDegree(Graph g, Direction direction) {
		String maxID = null;
		Integer maxDegree = Integer.MIN_VALUE;
		for (Vertex v : g.getVertices()) {
			int size = v.getVertices(direction).size();
			if (size > maxDegree) {
				maxID = v.getId();
				maxDegree = size;
				System.out.println(maxID + " : " + maxDegree);
			}
		}
	}
}
