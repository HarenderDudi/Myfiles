package com.cs.array;

public class SortArrayOfZeroOneTwo {

	public static void main(String[] args) {
//		int A[] = { 0, 1, 2, 0, 1, 2, 0};
		int A[] = { 2, 1, 0, 2, 1, 0, 1};
		int i = 0;
		int start = 0;
		int end = A.length - 1;
		
		while(i <= end) {
			if(A[i] == 0) {
				swap(A, i , start);
				start ++;
			} else if(A[i] == 1) {
				i++;
			} else {
				swap(A, i , end);
				end--;	
			}
		}
		
		printArray(A);
		
	}
	
	private static void swap(int[] arr, int i, int j) {
		int swap = arr[i];
		arr[i] = arr[j];
		arr[j] = swap;
	}

	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

}
