package com.cs.sortingalgo;

public class Heapsort {

	public static void main(String[] args) {
		
		//			         	  10(0)
		//		   	   8(1)	          		   12(2)
		//	    13(3)   	    2(4)  		9(5)     5(6)
		//  3(7)      11(8)
		
		int[] arr = {10,8,12,13,2,9,5,3,11};
		// heaped [13, 11, 12, 10, 2, 9, 5, 3, 8]
		sort(arr);
		
		int n = arr.length; // 9
		for (int i=0; i<n; ++i) 
            System.out.print(arr[i]+" "); 
        System.out.println(); 

	}
	
	public static void sort(int[] arr){
		int n = arr.length;
		
		for(int i= (n/2)-1 ; i>=0 ; i--){ //i = 3
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
		int parent = i;
		int l = 2*i+1;
		int r = 2*i+2;
		
		if( l < n && arr[l] > arr[parent]){
			parent = l;
		}
		
		if( r < n && arr[r] > arr[parent]){
			parent = r;
		}
		
		if(parent != i){
			int temp = arr[parent];
			arr[parent] = arr[i];
			arr[i] = temp;
			
			heapify(arr, n, parent);
		}
	}

}
