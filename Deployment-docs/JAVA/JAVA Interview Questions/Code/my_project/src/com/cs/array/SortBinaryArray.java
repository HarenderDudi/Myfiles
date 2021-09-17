package com.cs.array;

public class SortBinaryArray {

	public static void main(String[] args) {
//		int A[] = { 1, 0, 1, 0, 1, 0, 1};
		int A[] = { 1, 1, 1, 0, 0, 0, 1};
		int p = 0;
		
		for(int i = 0 ; i < A.length ; i ++) {
			if(A[i] == 0) {
				int temp = A[p];
				A[p] = A[i];
				A[i] = temp;
				
				p++;
			}
		}
		
		for (int i = 0; i < A.length; i++)
			System.out.print(A[i] + " ");
		
	}

}
