package com.dudi.sortingalgo;

public class SelectionSort {

	public static void main(String[] args) {
        // time complexity: O(n^2)
        int arr[] = { 12, 11,0, 13, 5, 6 }; // push lowest element to starting

        //2025// https://www.youtube.com/watch?v=HGk_ypEuS24&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=15
        int n = arr.length;
        for(int i=0;i<n-1;i++){
            int mini = i;
            for(int j = i; j<n;j++){
                if(arr[j] < arr[mini]){
                    mini = j;
                }
            }
            System.out.println("i: " + i + ", mini:" + arr[mini]);
            int temp = arr[i];
            arr[i] = arr[mini];
            arr[mini] = temp;
        }
	}

	static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i = 0; i < n; ++i) 
            System.out.print(arr[i] + " "); 
  
        System.out.println(); 
    } 
}