package com.cs.array;

import com.cs.utils.Utils;

public class TrappingRainWater {

	public static void main(String[] args) {
		int arr[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
//		int arr[] = { 0, 2, 0, 2};
//		int arr[] = { 0, 2, 0, 3, 0};
//		int arr[] = { 0, 1, 2, 3, 2, 1, 0};
        int n = arr.length;
        System.out.print(findWater(arr, n));
	}
	
	static int findWater(int[]arr, int size) {
		int prev = arr[0];
		int prevIndex = 0;
		int water = 0;
		
		// To store the water until a larger wall is found, if there are no larger walls then delete temp value from water
		int temp = 0;
		
		for(int i = 0; i < size; i++) {
			// if current wall is greater than prev wall then make it prev and clear temp
			if(arr[i] > prev) {
				prev = arr[i];
				prevIndex = i;
				temp = 0;
			} else {
				// if current wall is smaller then prev then add in water and temp
				water += prev - arr[i];
				temp += prev - arr[i];
			}
		}

		// if prevIndex is less then size of array then we didn't find the last wall greater or equal to prev wall then delete temp from water
		
		// eg: for index 0 to 7 (element 3)
		//			water: 5
		//			temp: 5
		// for index 7 (element 3) to 11
		// 			water : 11 [5 + 1(3-2) + 2(3-1) + 1(3-2) + 2(3-1)]
		// 			temp : 6
		
		// but we can store 1 water at index 9
		// remove temp from water 
		// iterate backward and store water
		if(prevIndex < size-1) {
			water -= temp;
			
			prev = arr[size - 1];
			for(int i = size-2; i >= prevIndex ; i--) {
				if(arr[i] > prev) {
					prev = arr[i];
				} else {
					water += prev - arr[i];
				}
			}
		}
		
		return water;
	}
	
	static int findWaterMethod1(int[]arr, int n) { 
		int left[] = new int[n]; 
		int right[] = new int[n]; 

		int water = 0; 

		left[0] = arr[0]; 
		for (int i = 1; i < n; i++) 
			left[i] = Math.max(left[i - 1], arr[i]); 
		
		Utils.printArray(left);
		
		right[n - 1] = arr[n - 1]; 
		for (int i = n - 2; i >= 0; i--) 
			right[i] = Math.max(right[i + 1], arr[i]); 

		Utils.printArray(right);
		
		for (int i = 0; i < n; i++) 
			water += Integer.max((Math.min(left[i], right[i]) - arr[i]),0);

		return water; 
	}

}
