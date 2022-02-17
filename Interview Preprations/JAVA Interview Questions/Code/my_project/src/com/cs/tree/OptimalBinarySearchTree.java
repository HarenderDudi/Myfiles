package com.cs.tree;

public class OptimalBinarySearchTree {

	public static void main(String[] args) {
		int[] n = {0,10,20,30,40};
		int[] f = {0,4,2,6,3};
		int size = n.length;
		
		int[][] wt = new int[size][size];
		int[][] cost = new int[size][size];
		int[][] node = new int[size][size];
		
		for (int d = 0; d < size; d++) {
			for (int i = 0; i < size - d; i++) {
				int j = i + d;
				if (i == j) {
					wt[i][j] = 0;
					cost[i][j] = 0;
					node[i][j] = 0;
					continue;
				}

				wt[i][j] = f[j] + wt[i][j - 1];

				int min = Integer.MAX_VALUE;
				for (int k = i + 1; k <= j; k++) {
					int treeCost = cost[i][k - 1] + cost[k][j] + wt[i][j];

					if (treeCost < min) {
						min = treeCost;
						cost[i][j] = min;
						node[i][j] = k;
					}
				}

			}
		}
		
		
//		printTable(cost, "Cost Table");
		printTable(node, "Node Table");
		
		int i = 0;
		int j = 4;
		int[] path = new int[size];
		getTree(i,j,node, path, -1, 1);
		
		
		
		for (int k : path) {
			System.out.println(k);
		}
		
	}
	
	private static void getTree(int i, int j, int[][] node, int[] path, int parent, int stage){
		
		if(i == j){
			return;
		}
		
		
		int pivot = node[i][j];

		System.out.println("-- pivot : " + pivot + "-- stage: " + stage);
		stage = stage + 1;
		
		getTree(i, pivot -1, node, path, pivot, stage);
		getTree(pivot, j, node, path, pivot, stage);
		
		path[pivot] = parent;
		
		
	}

	private static void printTable(int[][] cost, String tableName) {
		
		System.out.println(tableName + "\n");
		
		int size2 = cost[0].length;
		for(int i = 0; i < size2; i++){
			System.out.print("\t" + i);
		}
		System.out.print("\n\t-----------------------------------\n");
		
		for(int i = 0; i < cost.length; i++){
			System.out.print(i + " |");
			for(int j=0; j < size2; j++){
				System.out.print("\t" + cost[i][j]);
			}
			System.out.print("\n");
		}
		
		System.out.print("-----------------------------------\n\n");
	}

}
