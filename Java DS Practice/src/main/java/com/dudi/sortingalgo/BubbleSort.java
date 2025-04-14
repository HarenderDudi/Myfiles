package com.dudi.sortingalgo;

public class BubbleSort {

	public static void main(String[] args) {
        // time complexity: O(n^2)
        // https://www.youtube.com/watch?v=HGk_ypEuS24&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=15
        int arr[] = { 12, 11, 0, 13, 5, 6 }; // push hightest element to the end
//                    0   1   2   3  4  5
        /**
         * Step1
         *     n = 6 , i=5, j=0 swap [12, 11],
         *                  j=1 swap [12,0],
         *                  j=2 swap nothing
         *                  j=3 swap [13,5]
         *                  j=4 swap [13,6]
         */

        int n = arr.length;

        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
	  
        printArray(arr);
	}

	static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i = 0; i < n; ++i) 
            System.out.print(arr[i] + " "); 
  
        System.out.println(); 
    } 
}