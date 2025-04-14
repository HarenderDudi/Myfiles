package com.dudi.array.string.slidingwindow;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithNoRepeatingCharacters {

	public static void main(String[] args) {
//		https://www.youtube.com/watch?v=L6cffskouPQ&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=11
//		String s = "pwwkew";
		String s = "abcacefay";

		int i=0;
		int j=0;

		Map<Character, Integer> map = new HashMap<>();
		int ans = -1;
		while (j < s.length()){
			map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);

			if(map.size() == j-i+1){
				ans = Math.max(ans, j-i+1);
				j++;
			} else if(map.size() < j-i+1){
				while (map.size() < j-i+1){
					map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) - 1);

					if(map.get(s.charAt(i)) == 0){
						map.remove(s.charAt(i));
					}
					i++;
				}
				j++;
			}
		}
		System.out.println(ans);
		while (i < s.length()){
			System.out.print(s.charAt(i));
			i++;
		}
	}

}
