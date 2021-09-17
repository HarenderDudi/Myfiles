package com.cs.array.string.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithKUniqueCharacters {

	public static void main(String[] args) {
		// https://www.youtube.com/watch?v=Lav6St0W_pQ&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=10
//		char[] arr = {'a','a','b','a','c','e','b','e','b','e'};
//		int uniqueChar = 3;
		
//		char[] arr = "aabbcc".toCharArray();
//		int uniqueChar = 1;
		
//		char[] arr = "aabbcc".toCharArray();
//		int uniqueChar = 2;
		
//		char[] arr = "aabbcc".toCharArray();
//		int uniqueChar = 3;
//		
//		char[] arr = "aaabbb".toCharArray();
//		int uniqueChar = 3;
		
		char[] arr = "aabacbebebe".toCharArray();
		int uniqueChar = 3;
		
		int size = arr.length;
		int i = 0;
		int j = 0;
		
		int maxLength = 0;
		Map<Character, Integer> map = new HashMap<>();
		
		while(j < size) {
			// calculation
			int count = map.containsKey(arr[j]) ? map.get(arr[j]) : 0;
			map.put(arr[j], count + 1);
			
			if(map.size() < uniqueChar) {
				j++;
			}
			
			if(map.size() == uniqueChar) {
				// answer
				maxLength = Math.max(maxLength, j-i+1);
				j++;
			}
			
			if(map.size() > uniqueChar) {
				// calculation
				while(map.size() > uniqueChar) {
					int c = map.get(arr[i]);
					c = c - 1;
					if(c == 0) {
						map.remove(arr[i]);
					} else {
						map.put(arr[i], c);
					}
					i++;
					
					if(map.size() == uniqueChar) {
						maxLength = Math.max(maxLength, j-i+1);
					}
				}
				j++;
			}
		}
		
		System.out.println(maxLength);
		
	}

	//create a map for each char and its count
	//remove count if char moving out of window
	// a char will be removed of window if unique char in substring i.e map.size() is more than given 
	
}
