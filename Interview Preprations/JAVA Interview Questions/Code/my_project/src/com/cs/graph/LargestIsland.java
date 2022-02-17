package com.cs.graph;

import java.util.ArrayList;

public class LargestIsland {

	public static void main(String[] args) {
		// https://www.youtube.com/watch?v=tWVWeAqZ0WU
		int[][] island = new int[][] { 
					{ 1, 1, 0, 0, 0 },
					{ 0, 1, 0, 0, 1 },
					{ 1, 0, 0, 1, 1 },
					{ 0, 0, 0, 0, 0 },
					{ 1, 0, 1, 0, 1 }};
				
					
	   
		ArrayList<String> visited = new ArrayList<>();
		int maxSize = 0;
		for(int row=0; row < island.length; row++) {
			for(int col=0; col < island[0].length; col++) {
				int size = explore(island, row, col, visited);
				if(size > maxSize) {
					maxSize = size;
				}
				
			}
		}
		
		System.out.println(maxSize);

	}

	private static int explore(int[][] island, int row, int col, ArrayList<String> visited) {

		if(row < 0 || row >= island.length)
			return 0;
		
		if(col < 0 || col >= island[0].length)
			return 0;
		
		String currentPosition = row + "," + col;
		if (visited.contains(currentPosition)) {
			return 0;
		}

		visited.add(currentPosition);

		if (island[row][col] == 0) {
			return 0;
		}
		
		int size=1;
		
		size += explore(island, row, col + 1, visited);
		size +=explore(island, row + 1, col + 1, visited);
		size +=explore(island, row + 1, col, visited);

		size +=explore(island, row, col - 1, visited);
		size +=explore(island, row - 1, col - 1, visited);
		size +=explore(island, row - 1, col, visited);

		size +=explore(island, row - 1, col + 1, visited);
		size +=explore(island, row + 1, col - 1, visited);

		return size;

		
	}

}
