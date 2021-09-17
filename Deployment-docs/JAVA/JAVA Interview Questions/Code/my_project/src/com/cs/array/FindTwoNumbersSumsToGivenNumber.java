package com.cs.array;

import java.util.Arrays;
import java.util.HashMap;

public class FindTwoNumbersSumsToGivenNumber {

	public static void main(String[] args) {
		int[] arr = new int[] {2,9,4,10,6};

		// time complexity: O(nlogn): depends on sorting 
		//bySorting(arr, 15);
		
		// time compexity: O(n)
		byHashing(arr, 15);
	}
	
	public static void bySorting(int[] arr, int sum) {
		Arrays.sort(arr);
		System.out.println("sorted Array: " + arr.toString());
		int low = 0;
		int high = arr.length - 1;
		
		while (low < high) {
			int currentSum = arr[low] + arr[high];
			if(currentSum == sum) {
				System.out.println(++low + " --- " + ++high);
			} else if (currentSum < sum) {
				low++;
			} else {
				high--;
			}
		}
		
	}
	
	public static void byHashing(int[] arr, int sum) {
		HashMap map = new HashMap<>();
		for(int i = 0; i < arr.length; i++) {
			if(map.containsKey(arr[i])){
				System.out.println(i + " --- " + map.get(arr[i]));
			} else {
				map.put(sum - arr[i], i);
			}
		}
	}

}
