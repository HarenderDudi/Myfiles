package com.cs.binarysearch;

public class CountElementsInSortedArray {
	
	public static void main(String[] args) {
		int[] arr = new int[] {5,10,10,10,10,10,10,12};
		int first = findFirstOccurence(arr, 10);
		int last = findLastOccurence(arr, 10);
		
		System.out.println(last - first + 1);
		
	}
	
	private static int findFirstOccurence(int[] arr, int key) {
		
		int size = arr.length;
		int first = -1;
		int last = -1;

		int low = 0;
		int high = size - 1;

		while(low <= high) {
			int mid = low + ((high - low) / 2);
			
			if((mid == 0 || arr[mid-1] < key) && arr[mid] == key)
				return mid;
			else if(key <= arr[mid])
				high = mid -1;
			else
				low = mid + 1;
		}
		
		return -1;
	}
	
private static int findLastOccurence(int[] arr, int key) {
		
		int size = arr.length;
		int first = -1;
		int last = -1;

		int low = 0;
		int high = size - 1;

		while(low <= high) {
			int mid = low + ((high - low) / 2);
			
			if((mid == size-1 || arr[mid+1] > key) && arr[mid] == key)
				return mid;
			else if(key >= arr[mid])
				low = mid + 1;
			else
				high = mid -1;
		}
		
		return -1;
	}
	
}
