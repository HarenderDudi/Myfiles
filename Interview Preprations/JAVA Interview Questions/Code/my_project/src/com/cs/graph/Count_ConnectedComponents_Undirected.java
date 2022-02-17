package com.cs.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Count_ConnectedComponents_Undirected {

	public static void main(String[] args) {
		// https://www.youtube.com/watch?v=tWVWeAqZ0WU
		Map<String, List<String>> graph = createAndGetGraph();
		List<String> visitedNodes = new ArrayList<>();
		int count = 0;
		for (String node : graph.keySet()) {
			if(explore(graph, node, visitedNodes) == true) {
				count++;
			};
		}
		
		System.out.println("\nConnected Component Count is: " + count);
		
	}

	private static boolean explore(Map<String, List<String>> graph, String currentNode, List<String> visitedNodes) {

		if(visitedNodes.contains(currentNode)) 
			return false; 
		
		visitedNodes.add(currentNode);
		
		for(String neighbour: graph.get(currentNode)) {
			explore(graph, neighbour, visitedNodes);
		}
		
		return true;
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

