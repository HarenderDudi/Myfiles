package com.dudi.array;

import java.util.Arrays;

public class HackerRadioTransmittor {

	public static void main(String[] args) {
		int[] arr = {1, 7, 2, 4, 6, 5, 9, 12, 11,16,21};
		int range = 2;
		
		Arrays.sort(arr);
		// 2,4,5,6,7,9,11,12
		int size = arr.length;
		int installedTransmittors=0;
		int i = 0;
		
		while(i < size) {
			installedTransmittors++;
			int coveredHouses = arr[i] + (range);
			while(i < size && arr[i] <= coveredHouses) {
				i++;
			}
			
			coveredHouses = arr[--i] + range;
			System.out.println("install on house - " + arr[i]);
			while(i < size && arr[i] <= coveredHouses) {
				i++;
			}
		}
		
		System.out.println(installedTransmittors);
	}

}
