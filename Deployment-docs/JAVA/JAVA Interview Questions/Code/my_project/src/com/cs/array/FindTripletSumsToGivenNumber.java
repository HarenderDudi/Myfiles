package com.cs.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class FindTripletSumsToGivenNumber {

	public static void main(String[] args) {
		int A[] = { 4, 2, 3, 10, 6, 9, 1};
        int sum = 16;
        int arr_size = A.length;
 
     // time compexity: O(n^2)
        find3Numbers(A, arr_size, sum);
        
	}

	static boolean find3Numbers(int A[], int arr_size, int sum) {
		// Fix the first element as A[i]
		for (int i = 0; i < arr_size - 2; i++) {

			// Find pair in subarray A[i+1..n-1] with sum equal to sum - A[i]
			HashSet<Integer> s = new HashSet<Integer>();

			for (int j = i + 1; j < arr_size; j++) {
				if (s.contains(sum - A[j] - A[i])) {
					System.out.printf("\nTriplet is %d,  %d, %d", A[i], A[j], sum - A[j] - A[i]);
				}
				
				s.add(A[j]);
			}
		}

		// If we reach here, then no triplet was found
		return false;
	}

}
