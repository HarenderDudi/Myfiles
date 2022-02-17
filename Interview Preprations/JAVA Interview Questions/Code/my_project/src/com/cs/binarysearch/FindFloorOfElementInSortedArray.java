package com.cs.binarysearch;

public class FindFloorOfElementInSortedArray {

	public static void main(String[] args) {

		int[] arr = new int[] {1,2,3,4,8,10,10,12,19};
//		System.out.println(search(arr3, 50));
		System.out.println(searchFloorMethod1(arr, 20));
		System.out.println(searchFloorMethod2(arr, 20));
				
		
		
	}

	private static int searchFloorMethod1(int[] arr, int key) {
		int size = arr.length;
		int low = 0;
		int high = size-1;
		int value = -1;
		while(low <= high) {
			int mid = low + ((high - low)/2);
			if(arr[mid] == key) {
				return arr[mid];
			}
			else if(key > arr[mid]) {
				value = mid;
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		
		return arr[value];
	}
	
	private static int searchFloorMethod2(int[] arr, int key) {
		int size = arr.length;
		int low = 0;
		int high = size-1;
		int value = -1;
		while(low <= high) {
			int mid = low + ((high - low)/2);
			if(arr[mid] == key) {
				return arr[mid];
			}
			else if(key > arr[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		
		return arr[high];
	}

}
