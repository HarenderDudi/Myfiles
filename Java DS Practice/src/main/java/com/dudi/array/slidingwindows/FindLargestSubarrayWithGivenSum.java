package com.dudi.array.slidingwindows;

public class FindLargestSubarrayWithGivenSum {

//	Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
//	A subarray is a contiguous non-empty sequence of elements within an array.
//
//	Example 1:
//
//	Input: nums = [1,1,1], k = 2
//	Output: 2
//	Example 2:
//
//	Input: nums = [1,2,3], k = 3
//	Output: 2
	public static void main(String[] args) {
//		int[] arr = {3,2,7,1,6};
//		int tgt_sum = 10;
		
		int[] arr = {6,1,2,1,9,3,5};
		int tgt_sum = 5;
		
		int size = arr.length;
		int i = 0;
		int j = 0;
		int sum = 0;
		int max_subarray_length = 0;
		while(j < size) {
			sum += arr[j];
			
			if(sum < tgt_sum)
				j++;
			
			else if(sum == tgt_sum) {
				max_subarray_length = Math.max(max_subarray_length, j-i+1);
				j++;
			}
			
			
			else if(sum > tgt_sum) {
				while(sum > tgt_sum) {
					sum -= arr[i];
					i++;
					if(sum == tgt_sum) {
						max_subarray_length = Math.max(max_subarray_length, j-i+1);
						break;
					}	
				}
				j++;
			}
		}
		System.out.println(max_subarray_length);
	}

}
