package com.dudi.array;

public class FindJudgeInTown {

	public static void main(String[] args) {

		int[][] arr = {{1,3},{1,4},{2,3},{2,4},{4,3}};
		System.out.println(findJudge(arr, 4));
		
//		int[][] arr = {{1,3},{2,3},{3,1}};
//		int[][] arr = {{1,3},{2,3}};
//		int[][] arr = {{1,3}};
//		System.out.println(findJudge(arr, 3));
		
	}

	private static int findJudge(int[][] arr, int N) {
		
		int[][] trust = new int[N+1][2]; //col1: trusts, col2: trustedBy

		for(int[] a : arr) {
			trust[a[0]][0] ++;
			trust[a[1]][1] ++;
		}
		
		for(int i = 1; i <= N; i++){
			if(trust[i][0] == 0 && trust[i][1] == N-1) {
				return i;
			}
		}
		
		return -1;
	}
	
}
