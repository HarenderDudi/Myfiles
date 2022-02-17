package com.cs.binarysearch;

public class SearchInNearlySortedArray {

	public static void main(String[] args) {

//		int[] arr = new int[] {5,10,30,20,40};
//		System.out.println(search(arr, 20));
		
//		int[] arr1 = new int[] {5};
//		System.out.println(search(arr1, 5));
		
//		int[] arr2 = new int[] {5,10};
//		System.out.println(search(arr2, 20));
		
//		int[] arr3 = new int[] {5,10,30};
//		System.out.println(search(arr3, 30));
		
		int[] arr3 = new int[] {5,10,30,20};
		System.out.println(search(arr3, 50));
	}
	
	private static int search(int[] arr, int key) {
		
		int size = arr.length;
		
		if(arr[0] == key) {
			return 0;
		}
		
		if(arr[size-1] == key) {
			return size-1;
		}
		
		int low = 1;
		int high = size - 2;
		
		while(low <= high) {
			int mid = low + ((high - low) / 2);
			
			if(arr[mid] == key)
				return mid;
			
			if(arr[mid-1] == key)
				return mid-1;
			
			if(arr[mid+1] == key)
				return mid+1;
			
			if(key > arr[mid])
				low = mid+2;
			else
				high = mid-2;
			
		}
		
		return -1;
	}

}
