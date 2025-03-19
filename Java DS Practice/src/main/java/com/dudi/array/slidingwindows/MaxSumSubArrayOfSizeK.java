package com.dudi.array.slidingwindows;

public class MaxSumSubArrayOfSizeK {

	public static void main(String[] args) {
		int[] arr = {100, 200, 300, 400}; // k=2 max output:700  min output: 300
//		int[] arr = {1, 4, 2, 10, 23, 3, 1, 0, 20}; // k=4, output: 39
		max(arr,2);
		min(arr,2);
	}
	
	private static void max(int[] arr, int k) {
		int size = arr.length;
		
		int i = 0;
		int j = 0;
		int sum = 0;
		int max = 0;
		
		if(size < k) {
			System.out.println("invalid input");
			return;
		}
		
		while(j < size) {
			sum += arr[j];
			
			if(j-i+1 < k) {
				j++;
			}
			else {
				max = Math.max(sum, max);
				sum = sum - arr[i];
				i++;
				j++;
			}
		}
		System.out.println(max);
	}
	
	private static void min(int[] arr, int k) {
		int size = arr.length;
		
		int i = 0;
		int j = 0;
		int sum = 0;
		int min = Integer.MAX_VALUE;
		
		if(size < k) {
			System.out.println("invalid input");
			return;
		}
		
		while(j < size) {
			sum += arr[j];
			
			if(j-i+1 < k) {
				j++;
			}
			
			else {
				min = Math.min(sum, min);
				sum = sum - arr[i];
				i++;
				j++;
			}
		}
		System.out.println(min);
	}

}
