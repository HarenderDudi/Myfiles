package com.dudi.array.slidingwindows;

import java.util.LinkedList;
import java.util.List;

public class FindFirstNegativeNumberInWindow {

	public static void main(String[] args) {

//		int[] arr = {12,-1,-7,5,8,-10,6,7,8}; // -1-1-7-10-10-100, k=3
		int arr[] = {12, -1, -7, 8, -15, 30, 16, 28}; // -1 -1 -7 -15 -15 0, k=3
		printNegativeNumbers(arr,3);
		
	}
	
	private static void printNegativeNumbers(int[] arr, int k) {
		int size = arr.length;
		
		int i = 0;
		int j = 0;
		List<Integer> list = new LinkedList<>();
		
		if(size < k) {
			System.out.println("invalid input");
			return;
		}
		
		while(j < size) {

			if(arr[j] < 0)
				list.add(arr[j]);
			
			if(j-i+1 < k)
				j++;
			else {
				if(!list.isEmpty()) {
					System.out.print(list.get(0)+", " );
					if(list.get(0) == arr[i])
						list.remove(0);
				}else {
					System.out.print("0");
				}
				i++;
				j++;
			}
		}
	}

}
