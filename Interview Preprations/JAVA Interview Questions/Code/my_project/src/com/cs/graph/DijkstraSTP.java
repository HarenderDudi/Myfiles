package com.cs.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraSTP {

	static final int V = 6;
	
	public static void main(String[] args) {
		VertexD a = new VertexD(0);
		VertexD b = new VertexD(1);
		VertexD c = new VertexD(2);
		VertexD d = new VertexD(3);
		VertexD e = new VertexD(4);
		VertexD f = new VertexD(5);
		
		EdgeD e1 = new EdgeD(b, 2);
		EdgeD e2 = new EdgeD(c, 4);
		
		EdgeD e3 = new EdgeD(e, 7);
		EdgeD e4 = new EdgeD(c, 1);
		
		EdgeD e5 = new EdgeD(d, 3);
		
		EdgeD e6 = new EdgeD(e, 2);
		EdgeD e7 = new EdgeD(f, 5);
		
		EdgeD e8 = new EdgeD(f, 1);
		
		a.addEdges(e1);
		a.addEdges(e2);
		
		b.addEdges(e3);
		b.addEdges(e4);
		
		c.addEdges(e5);
		
		d.addEdges(e6);
		d.addEdges(e7);
		
		e.addEdges(e8);
		
		a.minDistance = 0;
		
		int[] path = dikstra(a);

		for(int i=0; i<path.length ; i++){
			System.out.println(path[i]);
		}
		
	}
	
	public static int[] dikstra(VertexD source){
		int[] stp = new int[V];
		int[] parent = new int[V];
		PriorityQueue<VertexD> queue = new PriorityQueue<>();

		initialize(parent);
		
		queue.add(source);
		
		while(!queue.isEmpty()){
			VertexD v = queue.poll();
			stp[v.id] = 1;
			
			for(EdgeD e: v.edges){
				VertexD u = e.target;
				int minDistance = v.minDistance + e.weight;
				if(stp[u.id] != 1 && u.minDistance > minDistance){
					u.minDistance = minDistance;
					parent[u.id] = v.id;
					queue.add(u);
				}
			}
		}
		
		return parent;
		
	}

	private static void initialize(int[] parent) {
		for(int i=0; i<V ; i++){
			parent[i] = -1;
		}
	}

}

class VertexD implements Comparable<VertexD>{
	int id;
	int minDistance = Integer.MAX_VALUE;
	List<EdgeD> edges = new ArrayList<EdgeD>();
	
	public VertexD(int id){
		this.id = id;
	}
	
	public void addEdges(EdgeD e){
		edges.add(e);
	}

	@Override
	public int compareTo(VertexD v) {
		return this.minDistance - v.minDistance;
	}
	
}

class EdgeD
{
    public final VertexD target;
    public final int weight;
    public EdgeD(VertexD argTarget, int argWeight)
    { target = argTarget; weight = argWeight; }
}
