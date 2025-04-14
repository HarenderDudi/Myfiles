package com.dudi.array;

public class MaxSubArraySumKadaneAlgorithm {

	public static void main(String[] args) {
		int arr[] = { -2, -3, 4, -1, -4, 1, 5, -3 };

		int sum = 0;
		int maxSum = 0;

				
				
		//maxSum = dynamicPrograming(arr, maxSum);
		KadaneAlgorithm(arr, sum, maxSum);
	}

	private static void KadaneAlgorithm(int[] arr, int sum, int maxSum) {
		int start = -1;
		int end = -1;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];

			if(sum > maxSum){
				maxSum = sum;
				end = i;
			}

			if(sum < 0){
				sum = 0;
				start = i+1;
			}
		}

		System.out.println(maxSum + "---" + ++start + "-"+ ++end);
	}

	private static int dynamicPrograming(int[] arr, int maxSum) {
		int sum;
		sum = arr[0];
		for (int i = 1; i < arr.length; i++) {
			sum = Math.max(arr[i], sum + arr[i]);
			System.out.println("i: " + i + "\t max:" + sum);
			if(maxSum < sum){
				maxSum = sum;
			}
		}
		return maxSum;
	}

}
