package com.cs.array;

public class ProductOfArrayExceptSelf {

	public static void main(String[] args) {

		int[] arr = { 10, 3, 5, 2 };
		int size = arr.length;
		int[] result = new int[size];

//		naiveMethod(arr, size, result);
		efficientMethod(arr, size, result);

		printArray(result);
		
	}

	private static void naiveMethod(int[] arr, int size, int[] result) {
		int[] t1 = new int[size];
		int[] t2 = new int[size];
 
		t1[0]=1;
		t2[size-1]=1;
 
		// scan from left to right
		for(int i=1; i<size; i++){
		    t1[i] = arr[i-1] * t1[i-1];
		}
		
		printArray(t1);
 
		//scan from right to left
		for(int i=size-2; i>=0; i--){
		    t2[i] = t2[i+1] * arr[i+1];
		}
		
		printArray(t2);
 
		//multiply
		for(int i=0; i<size; i++){
		    result[i] = t1[i] * t2[i];
		}
	}

	private static void efficientMethod(int[] arr, int size, int[] result) {
		int left = 1;
		// store the product upto i-1 index from the start of array
		for(int i=0; i < size; i++) {
			result[i] = left;
			left = left * arr[i];
		}
		
		int right = 1;
		for(int i = size-1; i >= 0 ; i--) {
			result[i] = result[i] * right;
			right = right * arr[i];
		}
	}
	
	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

}
