package com.dudi;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class practiceMain {

    public static void main(String[] args) {
//        firstNegativeNumberInSubstr();
//        longestSubStringWithKUniqueCharacters();

    }

    private static void longestSubStringWithKUniqueCharacters() {
        String s = "aabacbebebe";
        int k = 3;

        int i=0;
        int j=0;
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();

        long max = -1L;

        while(j < s.length()) {
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch,0)+1);

            if(map.size()<k){
                j++;
            } else if (map.size() == k) {
                System.out.println("i:" + i +", j:" + j);
                max = Math.max(max, j-i+1);
                j++;
            } else {
                while(map.size() > k){
                    Integer count = map.get(chars[i]);
                    count = count-1;
                    if(count == 0){
                        map.remove(chars[i]);
                    } else {
                        map.put(chars[i], count);
                    }
                    i++;
                }
                j++;
            }
        }

        System.out.println(max);
    }

    private static void firstNegativeNumberInSubstr() {
        int arr[] = {12, -1, -7, 8, -15, 30, 16, 28}; // -1 -1 -7 -15 -15 0, k=3

        int windowSize = 3;
        int arrLength = arr.length;
        int i=0;
        int j=0;

        ArrayDeque<Integer> negativeList = new ArrayDeque<>();

        while(j < arrLength){
            if(arr[j] < 0){
                negativeList.offer(arr[j]);
            }

            if(j-i+1 < windowSize){
                j++;
            } else {
                if(negativeList.isEmpty()){
                    System.out.println("0");
                } else {
                    System.out.print(negativeList.peek()+", ");
                    if(arr[i] == negativeList.peek()){
                        negativeList.poll();
                    }
                }

                i++;
                j++;
            }
        }
    }


}
