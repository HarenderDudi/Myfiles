package com.dudi.array;

public class MajorityElementMooreVotingAlgorithm {

	public static void main(String[] args) {
		int arr[] = { 7,7,5,7,5,1,5,7,5,5,7,7,5,5,5,5};

		int el = arr[0];
		int count = 0;

		for(int i = 0; i < arr.length ; i++){
			int x = arr[i];
			if(count == 0){
				el = arr[i];
				count=1;
			} else if(arr[i]==el){
				count++;
			} else {
				count--;
			}
		}

		System.out.println(count);


	}


}
