package com.cs.binarysearch;

public class NumberOfTimesArrayIsRotated {

	public static void main(String[] args) {

		int[] arr = new int[] {11,12,15,18,2,5,6,8};
//		int[] arr = new int[] {15,18,2,5,6,8,11,12};
//		int[] arr = new int[] { 2, 5, 6, 8, 11, 12, 15, 18 };
		int n = arr.length;
		int start = 0;
		int end = arr.length - 1;

		System.out.println(findMin(arr, n, start, end));

	}

	private static int findMin(int[] arr, int n, int start, int end) {
		// If the list has just one element then return that element.
		if (arr.length == 1) {
			return arr[0];
		}

		// Already sorted array.
		// Hence the smallest element is first element. A[0]
		if (arr[0] < arr[end]) {
			return arr[0];
		}

		while (start <= end) {
			int mid = start + (end - start) / 2;

			// if the mid element is greater than its next element then mid+1 element is the
			// smallest. This point would be the point of change. From higher to lower value.
			if (arr[mid] > arr[mid + 1]) {
				return arr[mid + 1];
			}

			// if the mid element is lesser than its previous element then mid element is the smallest
			if (arr[mid] < arr[mid - 1]) {
				return arr[mid];
			}

			// if the mid elements value is greater than the 0th element this means the least value is still 
			// somewhere to the right as we are still dealing with elements greater than nums[0]
			if (arr[mid] > arr[0]) {
				start = mid + 1;
			} else {
				// if nums[0] is greater than the mid value then this means the smallest value is somewhere to the left
				end = mid - 1;
			}
		}
		return -1;
	}

}
