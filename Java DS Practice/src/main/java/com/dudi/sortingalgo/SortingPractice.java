package com.dudi.sortingalgo;

public class SortingPractice {

	public static void main(String[] args) {
		
		System.out.println(9/5);
		
//		int [] arr = new int [] {2, 1, 5, 7, 9, 3, 6, 8};
//		quicksort(arr, 0, arr.length-1);
//		printArray(arr);
	}
	
	public static void quicksort(int[] arr, int low, int high) {
		
		
		if(low < high) {
			int i = low - 1;
			for(int j = low; j < high; j++) {
				if(arr[j] < arr[high]) {
					i++;
					swap(arr, i, j);
				}
			}
			
			
			i++;
			swap(arr, i, high);
			
			System.out.println("\npivot: " + i);
			printArray(arr);
			quicksort(arr, low, i-1);
			quicksort(arr, i+1, high);
		}
		
		
	}

	private static void swap(int[] arr, int i, int j) {
		int swap = arr[i];
		arr[i] = arr[j];
		arr[j] = swap;
	}
	
	  static void printArray(int arr[]) 
	    { 
	        int n = arr.length; 
	        for (int i=0; i<n; ++i) 
	            System.out.print(arr[i]+" "); 
	        System.out.println(); 
	    } 

}


