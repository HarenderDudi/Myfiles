package com.dudi.graph;

import java.util.ArrayList;

public class Island_count {

	public static void main(String[] args) {
		// https://www.youtube.com/watch?v=tWVWeAqZ0WU
		int[][] island = new int[][] { 
					{ 1, 1, 0, 0, 0 },
					{ 0, 1, 0, 0, 1 },
					{ 1, 0, 0, 1, 1 },
					{ 0, 0, 0, 0, 0 },
					{ 1, 0, 1, 0, 1 }};
				
					
	   
		ArrayList<String> visited = new ArrayList<>();
		int count = 0;
		for(int row=0; row < island.length; row++) {
			for(int col=0; col < island[0].length; col++) {
				if(explore(island, row, col, visited)) {
					count++;
				};
				
				
			}
		}
		
		System.out.println(count);

	}

	private static boolean explore(int[][] island, int row, int col, ArrayList<String> visited) {

		if(row < 0 || row >= island.length)
			return false;
		
		if(col < 0 || col >= island[0].length)
			return false;
		
		String currentPosition = row + "," + col;
		if (visited.contains(currentPosition)) {
			return false;
		}

		visited.add(currentPosition);

		if (island[row][col] == 0) {
			return false;
		}
		
		
		explore(island, row, col + 1, visited);
		explore(island, row + 1, col + 1, visited);
		explore(island, row + 1, col, visited);

		explore(island, row, col - 1, visited);
		explore(island, row - 1, col - 1, visited);
		explore(island, row - 1, col, visited);

		explore(island, row - 1, col + 1, visited);
		explore(island, row + 1, col - 1, visited);

		return true;

		
	}

}
