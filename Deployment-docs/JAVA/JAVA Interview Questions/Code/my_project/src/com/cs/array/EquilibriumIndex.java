package com.cs.array;

public class EquilibriumIndex {

	public static void main(String[] args) {
		int[] arr = {-7, 1, 5, 2, -4, 3, 0};
//		int[] arr = {1,2,3};
		System.out.println(getEquilibriumIndex(arr));
		
	}

	
//	The idea is to get the total sum of the array first. Then Iterate through the array and keep updating the left sum
//	which is initialized as zero. In the loop, we can get the right sum by subtracting the elements one by one
	private static int getEquilibriumIndex(int[] arr) {
		int size = arr.length;
		int sum = 0;
		
		for(int i = 0 ; i < size ; i++)
			sum += arr[i];
		
		int leftSum = 0;
		for(int i = 0 ; i < size ; i++) {
			sum = sum - arr[i]; // now sum is right sum for index i
			
			if(sum == leftSum) {
				return i;
			}
			
			leftSum += arr[i];
		}
		
		return -1;
	}

}
