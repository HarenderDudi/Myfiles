package com.dudi.graph;

import java.util.ArrayList;
import java.util.List;

public class DetectCycleUnion {

	public static void main(String[] args) {
		Edge e1 = new Edge(0, 1);
		Edge e2 = new Edge(1, 2);
		Edge e3 = new Edge(2, 3);
		
		Graph g = new Graph(4, 3);
		g.addEdge(e1);
		g.addEdge(e2);
		g.addEdge(e3);
		
		int response = isCycle(g);
		
		if(response == 1){
			System.out.println("Graph is does not contains cycle");
		}else{
			System.out.println("** Graph is contains Cycle **");
		}
	}
	
	public static int find(int[] parent, int v){

		int rootParent = v;
		
		while(parent[rootParent] != -1){
			rootParent = parent[v];
		}

		if(rootParent != v){
			parent[v] = rootParent;
		}

		return rootParent;
	}
	
	/*public static void union(int[] parent, int v1, int v2){
		
		int p1 = find(parent, v1);
		int p2 = find(parent, v2);
		
		parent[p2] = p1;
		
	}*/
	
	public static int isCycle(Graph g){
		
		int[] parent = new int[g.totalVertex];
		
		for (int i=0; i<g.totalVertex; ++i){
			parent[i]=-1; 
		}
		
		List<Edge> edges = g.edges;
		for(Edge e : edges){
			int src = e.src;
			int dest = e.dest;
			
			int p1 = find(parent, src);
			int p2 = find(parent, dest);
			
			if(p1 == p2){
				return -1;
			}
			
			parent[p2] = p1;
		}
		
		return 1;
	}

}

class Edge{
	int src;
	int dest;
	
	Edge(int src, int dest){
		this.src = src;
		this.dest = dest;
	}
	
}

class Graph{
	
	int totalVertex;
	int totalEdges;
	List<Edge> edges = new ArrayList<Edge>();
	
	Graph(int totalVertex, int totalEdges){
		this.totalEdges = totalEdges;
		this.totalVertex = totalVertex;
	}
	
	public void addEdge(Edge e){
		this.edges.add(e);
	}
	
	
	
	
	
}
