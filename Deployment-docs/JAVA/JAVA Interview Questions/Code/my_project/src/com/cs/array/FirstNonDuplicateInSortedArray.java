package com.cs.array;

public class FirstNonDuplicateInSortedArray {

	public static void main(String[] args) {
		int[] arr = { 1, 1, 2, 4, 4, 5, 5, 6, 6 };
//		int[] arr = { 1, 1, 2, 2, 4, 4, 5, 5, 6 };
//		int[] arr = { 1, 2, 2, 4, 4, 5, 5, 6, 6 };
		
		int start = 0;
		int end = arr.length-1;
		
		while(start < end){
			int mid = start + (end-start)/2;
			if(mid%2==1)
				mid--;
			
			// move left if even and odd index element are not same
			// else move right
			
			if(arr[mid] != arr[mid+1])
				end=mid;
			
			else start = mid+2;
		}
		
		System.out.println(arr[start]);;
		
	}


}
