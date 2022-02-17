package com.cs.sortingalgo;

public class Mergesort {

	public static void main(String[] args) {

		int[] arr = {10,8,12,13,2,9,5,3,11};
		int n = arr.length;

		mergeSort(arr, 0, n-1);
		
		for (int i=0; i<n; ++i) 
            System.out.print(arr[i]+" "); 
        System.out.println(); 
		
	}

	public static void mergeSort(int[] arr, int l, int h) {
		if (l < h) {
			int mid = (l + h) / 2;
			mergeSort(arr, l, mid);
			mergeSort(arr, mid + 1, h);
			merge(arr, l, mid, h);
		}
	}

	public static void merge(int[] arr, int l, int m, int h){
		int[] temp = new int[h-l + 1];
		
		int i = l;
		int j = m +1;
		int k = 0;
		
		while(i <= m && j <= h){
			if(arr[i] <= arr[j]){
				temp[k++] = arr[i++];
			}
			else{
				temp[k++] = arr[j++];
			}
		}
		
		while(i<=m){
			temp[k++] = arr[i++];
		}
		
		while(j<=h){
			temp[k++] = arr[j++];
		}
		
		for(int x=0; x<temp.length; x++){
			arr[l++] = temp[x]; 
		}
	}

}
