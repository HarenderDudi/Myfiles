package com.cs.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class ShortedPath_Undirected {

	
	public static void main(String[] args) {
		// https://www.youtube.com/watch?v=tWVWeAqZ0WU
		Map<String, List<String>> graph = createAndGetGraph();
		List<String> visitedNodes = new ArrayList<>();

		int distance = getShortestPath(graph, "A", "F", visitedNodes);
		
		System.out.println("\nshortest Distance is: " + distance);
		
	}
	
	private static int getShortestPath(Map<String, List<String>> graph, String srcNode, String tgtNode, List<String> visitedNodes) {

		Queue<Object[]> queue = new LinkedList<>();
		queue.add(new Object[] {srcNode, 0});
		visitedNodes.add(srcNode);
		
		while(!queue.isEmpty()) {

			printQueue(queue);
			
			Object[] currentNode = queue.poll();
			
			String node = (String) currentNode[0];
			Integer distance = (Integer) currentNode[1];

			if(node == tgtNode) {
				return distance;
			}
			
			for(String neighbor : graph.get(node)) {
				if(!visitedNodes.contains(neighbor)) {
					queue.add(new Object[] {neighbor, distance + 1});
					visitedNodes.add(neighbor);
				}
			}
		}
		
		
		return -1;
	}

	private static void printQueue(Queue<Object[]> queue) {
		System.out.println("\n");
		for(Object[] q: queue) {
			System.out.print("--" + q[0]);
		}
	}

	private static Map<String, List<String>> createAndGetGraph() {
				
				ArrayList<ArrayList<String>> edges = new ArrayList() {{
					add(List.of("A", "B"));
					add(List.of("B", "C"));
					add(List.of("C", "F"));
					add(List.of("A", "E"));
					add(List.of("E", "F"));
					
				}};
				
				Map<String, List<String>> graph = getGraph(edges);
				graph.forEach((k,v) -> System.out.println(k + " -- "+ v));
		return graph;
	}

	private static Map<String, List<String>> getGraph(ArrayList<ArrayList<String>> edges) {
		Map<String, List<String>> graph = new HashMap<>();

		for (List<String> edge : edges) {
			if(!graph.containsKey(edge.get(0))) {
				graph.put(edge.get(0), new ArrayList<>());
			}
			if(!graph.containsKey(edge.get(1))) {
				graph.put(edge.get(1), new ArrayList<>());
			}
			
			graph.get(edge.get(0)).add(edge.get(1));
			graph.get(edge.get(1)).add(edge.get(0));
		}
		
		return graph;
		
	}
	
}

