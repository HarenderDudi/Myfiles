package com.cs.graph;

import java.util.ArrayList;
import java.util.List;

public class DetectCycleInDirectedGraph {
	
	final static Integer V = 5; 
	
	public static void main(String[] args) {
		boolean[] visited = new boolean[V];
		boolean[] recStack = new boolean[V];
		
		VertexDG v0 = new VertexDG(0);
		VertexDG v1 = new VertexDG(1);
		VertexDG v2 = new VertexDG(2);
		VertexDG v3 = new VertexDG(3);
		VertexDG v4 = new VertexDG(4);
		
		v0.addAdjVertices(v0);

		/*v0.addAdjVertices(v1);
		v0.addAdjVertices(v2);
		v1.addAdjVertices(v3);
		v3.addAdjVertices(v4);
		v4.addAdjVertices(v2);*/
		
		System.out.println("Graph Contain Cycle: " + detectCycle(v0, visited, recStack));
		
	}
	
	public static boolean detectCycle(VertexDG s, boolean[] visited, boolean[] recStack){
		
		if(recStack[s.id]){
			return true;
		}
		
		if(visited[s.id]){
			return false;
		}
		
		visited[s.id] = true;
		recStack[s.id] = true;
		
		
		for (VertexDG v : s.adjVertex) {
			if (detectCycle(v, visited, recStack)) {
				return true;
			}
		}

		return false;
	}


}

class VertexDG{
	
	int id;
	List<VertexDG> adjVertex = new ArrayList<VertexDG>();
	
	public VertexDG(int id) {
		this.id = id;
	}
	
	public void addAdjVertices(VertexDG v){
		adjVertex.add(v);
	}
	
}
