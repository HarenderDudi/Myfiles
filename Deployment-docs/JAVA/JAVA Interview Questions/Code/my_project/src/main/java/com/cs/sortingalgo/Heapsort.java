package com.cs.sortingalgo;

public class Heapsort {

	public static void main(String[] args) {
		
		int[] arr = {10,8,12,13,2,9,5,3,11};
		sort(arr);
		
		int n = arr.length;
		for (int i=0; i<n; ++i) 
            System.out.print(arr[i]+" "); 
        System.out.println(); 

	}
	
	public static void sort(int[] arr){
		int n = arr.length;
		
		for(int i= (n/2)-1 ; i>=0 ; i--){
			heapify(arr, n, i);
		}
		
		for(int i = n-1 ; i>=0; i--){
			int temp = arr[i];
			arr[i] = arr[0];
			arr[0] = temp;
			
			heapify(arr, i, 0);
		}
		
        
		
	}
	
	public static void heapify(int[] arr, int n, int i){
		int largest = i;
		int l = 2*i+1;
		int r = 2*i+2;
		
		if( l < n && arr[l] > arr[largest]){
			largest = l;
		}
		
		if( r < n && arr[r] > arr[largest]){
			largest = r;
		}
		
		if(largest != i){
			int temp = arr[largest];
			arr[largest] = arr[i];
			arr[i] = temp;
			
			heapify(arr, n, largest);
		}
	}

}
