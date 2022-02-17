package com.cs.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KrushkalMST {

	public static void main(String[] args) {

		GraphK graph = new GraphK(9, 14);
		
		EdgeK e1 = new EdgeK(0, 1, 4);
		EdgeK e2 = new EdgeK(1, 2, 9);
		EdgeK e3 = new EdgeK(2, 3, 7);
		EdgeK e4 = new EdgeK(3, 4, 9);
		EdgeK e5 = new EdgeK(4, 5, 10);
		EdgeK e8 = new EdgeK(5, 6, 2);
		EdgeK e10 = new EdgeK(6, 7, 1);
		EdgeK e14 = new EdgeK(7, 0, 8);

		EdgeK e13 = new EdgeK(1, 7, 11);
		EdgeK e11 = new EdgeK(2, 8, 2);
		EdgeK e9 = new EdgeK(8, 6, 6);
		EdgeK e6 = new EdgeK(3, 5, 14);
		EdgeK e12 = new EdgeK(7, 8, 7);
		EdgeK e7 = new EdgeK(5, 2, 4);
		
		graph.addEdge(e1);
		graph.addEdge(e2);
		graph.addEdge(e3);
		graph.addEdge(e4);
		graph.addEdge(e5);
		graph.addEdge(e6);
		graph.addEdge(e7);
		graph.addEdge(e8);
		graph.addEdge(e9);
		graph.addEdge(e10);
		graph.addEdge(e11);
		graph.addEdge(e12);
		graph.addEdge(e13);
		graph.addEdge(e14);
		
		
		List<EdgeK> result = krushalMST(graph);
		
		for (EdgeK edgeK : result) {
			System.out.println(edgeK.src +"  ----  "+ edgeK.dest +" -- W: "+ edgeK.weigth);
		}
		
	}
	
	public static List<EdgeK> krushalMST(GraphK g){
		// sort edges on weight basis
		// get 1st edge and check if src and dest create cycle
		// if Yes, Ignore
		// otherwise add edge in results array
		
		int[] parent = new int[g.totalVertex];
		List<EdgeK> result = new ArrayList<>();
		
		for (int i = 0; i < g.totalVertex; ++i) {
			parent[i] = -1;
		}

		ArrayList<EdgeK> edges = (ArrayList<EdgeK>) g.edges;
		Collections.sort(edges);

		for (int i = 0; i < g.totalEdges; i++) {
			EdgeK edge = edges.get(i);

			int src = edge.src;
			int dest = edge.dest;
			
			int p1 = find(parent, src);
			int p2 = find(parent, dest);
			
			if(p1 != p2){
				result.add(edge);
				parent[p2] = p1;
			}
			
			if(result.size() == g.totalVertex-1){
				break;
			}
		}
		
		return result;
	}
	
	public static int find(int[] parent, int v){
		
		int rootParent = v;
		
		while(parent[rootParent] != -1){
			rootParent = parent[rootParent];
		}

		if(rootParent != v){
			parent[v] = rootParent;
		}

		return rootParent;
	}

}



class EdgeK implements Comparable<EdgeK>{
	final int src;
	final int dest;
	final int weigth;
	
	
	EdgeK(int src, int dest, int weight){
		this.src = src;
		this.dest = dest;
		this.weigth = weight;
	}
	
	@Override
	public int compareTo(EdgeK o) {
		return this.weigth - o.weigth;
	}
	

}

class GraphK{
	
	int totalVertex;
	int totalEdges;
	List<EdgeK> edges = new ArrayList<EdgeK>();
	
	GraphK(int totalVertex, int totalEdges){
		this.totalEdges = totalEdges;
		this.totalVertex = totalVertex;
	}
	
	public void addEdge(EdgeK e){
		this.edges.add(e);
	}
	
	
	
	
	
}