package com.dudi.array;

import java.util.HashSet;

public class FindTripletSumsToGivenNumber {

	public static void main(String[] args) {
		int arr[] = { 4, 2, 3, 10, 6, 9, 1};
        int sum = 16;
        int arr_size = arr.length;
 
     // time compexity: O(n^2)
        find3Numbers(arr, arr_size, sum);

		// sorting technique without using extra space
		// time complexity: nLogn(soring) + n*n (for traversing array using 3 pointers)
	}

	static boolean find3Numbers(int arr[], int arr_size, int sum) {
		// Fix the first element as arr[i]
		for (int i = 0; i < arr_size - 2; i++) {

			// Find pair in subarray arr[i+1..n-1] with sum equal to sum - arr[i]
			HashSet<Integer> s = new HashSet<Integer>();

			for (int j = i + 1; j < arr_size; j++) {
				if (s.contains(sum - arr[j] - arr[i])) {
					System.out.printf("\nTriplet is %d,  %d, %d", arr[i], arr[j], sum - arr[j] - arr[i]);
				}
				
				s.add(arr[j]);
			}
		}

		// If we reach here, then no triplet was found
		return false;
	}

}
