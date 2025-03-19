package com.dudi;

import java.util.ArrayDeque;

public class practiceMain {

    public static void main(String[] args) {
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
