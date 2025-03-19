package com.dudi.array.strings;

public class SortStringOfCharacter {

	static final int MAX_CHAR = 26;
	
	public static void main(String[] args) {
		sortString("geeksforgeeks");
	}
	
	 static void sortString(String str) {
		 int[] result = new int[MAX_CHAR];
		 
		 for(char x : str.toCharArray()) {
			 result[x - 'a']++;
		 }
		 
		 for(int i = 0 ; i < MAX_CHAR ; i++) {
			 for(int j = 0; j < result[i]; j++) {
				 System.out.print((char)(i + 'a'));
			 }
		 }
	 }

}
