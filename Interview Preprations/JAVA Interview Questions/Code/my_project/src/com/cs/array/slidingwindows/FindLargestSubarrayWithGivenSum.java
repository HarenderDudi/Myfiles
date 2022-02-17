package com.cs.array.slidingwindows;

public class FindLargestSubarrayWithGivenSum {

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
