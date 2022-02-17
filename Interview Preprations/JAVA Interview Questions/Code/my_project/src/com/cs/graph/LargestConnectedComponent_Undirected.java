package com.cs.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LargestConnectedComponent_Undirected {
	
	public static void main(String[] args) {
		// https://www.youtube.com/watch?v=tWVWeAqZ0WU
		Map<String, List<String>> graph = createAndGetGraph();
		
		List<String> visitedNodes = new ArrayList<>();
		int maxComponentSize = 0;
		
		for (String node : graph.keySet()) {
			int componentSize = explore(graph, node, visitedNodes);
			if( componentSize > maxComponentSize) {
				maxComponentSize = componentSize;
			};
		}
		
		System.out.println("\nConnected Component Count is:" + maxComponentSize);
		
	}

	private static int explore(Map<String, List<String>> graph, String currentNode, List<String> visitedNodes) {
		if(visitedNodes.contains(currentNode)){
			return 0;
		}
		
		visitedNodes.add(currentNode);
		
		int size = 1;
		
		for(String neightbour : graph.get(currentNode)) {
			size += explore(graph, neightbour, visitedNodes);
		}
		
		return size;
	}

	private static Map<String, List<String>> createAndGetGraph() {
		//		 List<List<String>> of = List.of(
		//				 	List.of("A", "B"),
		//				 	List.of("C", "D"),
		//				 	List.of("C", "E"));
				
				ArrayList<ArrayList<String>> edges = new ArrayList() {{
					add(List.of("A", "B"));
					add(List.of("C", "D"));
					add(List.of("D", "E"));
					add(List.of("D", "F"));
					add(List.of("D", "G"));
					add(List.of("H", "I"));
					
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
