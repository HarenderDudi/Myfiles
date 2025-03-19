package com.dudi.array.string.slidingwindow;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountOccurrencesAnagrams {

	public static void main(String[] args) {
		// https://www.youtube.com/watch?v=MW4lJ8Y0xXk&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=5
		
		// create a frequency map for characters in target string
		// create result = 0
		// create a count variable, count = map.size()
		// use sliding window
		// if(j-i+1 < k) -> get char from map and reduce its count, also check if its count is 0 then count--
		// if(j-i+1 == k) check if count is 0, yes then result++, since we are going to increase i++ we need to increment count for the arr[i] in map

		String pattern = "abba";
		char[] input = "acababaabcd".toCharArray();

		Map<Character, Long> freqMap = pattern.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		int windowSize = pattern.length();

		int i=0;
		int j=0;

		int count = freqMap.size();
		int ans = 0;

		while(j < input.length){
			if(freqMap.containsKey(input[j])){
				freqMap.put(input[j], freqMap.get(input[j])-1);

				if(freqMap.get(input[j]) == 0 && count>0){
					count--;
				}
			}

			if(j-i+1 < windowSize)
				j++;
			else {
				if(count==0){
					ans++;
				}

				if(freqMap.containsKey(input[i])){
					freqMap.put(input[i], freqMap.get(input[i])+1);
					if(freqMap.get(input[i]) > 0){
						count++;
					}
				}
				i++;
				j++;
			}
		}

		System.out.println(ans);
	}

}
