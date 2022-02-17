package com.cs.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class DFS_BFS {
	public static void main(String[] args) {
		Map<String, List<String>> graph = new HashMap<>();
		graph.put("a", Arrays.asList("c", "b"));
		graph.put("b", Arrays.asList("d"));
		graph.put("c", Arrays.asList("e"));
		graph.put("d", Arrays.asList("f"));
		graph.put("e", Arrays.asList());
		graph.put("f", Arrays.asList());
		
		System.out.println("Number of nodes: " + graph.size());
		
		Stack<String> stack = new Stack<>();
		
		System.out.println("---------------DFS----------------");
		System.out.println("Expected output: \n[a -> b -> d -> f -> c -> e]\n");
		dfs("a", stack, graph);
		
		System.out.println("\n---------------BFS----------------");
		System.out.println("Expected output: \n[a -> b -> c -> d -> e -> f]\n");
		bfs("a", new PriorityQueue(), graph);
	}
	
	public static void dfs(String key, Stack stack, Map<String, List<String>> graph) {
		System.out.print(key + " -> ");
		graph.get(key).stream().forEach(stack::push);
		if(stack.isEmpty()) {
			return;
		}
		dfs((String)stack.pop(), stack, graph);
	}
	
	public static void bfs(String key, PriorityQueue queue, Map<String, List<String>> graph) {
		System.out.print(key + " -> ");
		queue.addAll(graph.get(key));

		if(queue.isEmpty()) {
			return;
		}
		bfs((String)queue.poll(), queue, graph);
	}
	
	
}
