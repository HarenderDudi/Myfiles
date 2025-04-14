package com.dudi.recursion;

import java.util.Arrays;

public class ReverseArrayUsingRecursion {
    public static void main(String[] args) {

        int[] intput = {1,2,3,4,5,6};
//        reverseArrayTwoPointers(0, intput.length-1, intput);
        reverseArrayOnePointers(0,intput);
        Arrays.stream(intput).forEach(System.out::print);

    }

    private static void reverseArrayOnePointers(int l, int[] input){
        int n = input.length;
        if(l>=(n /2)){
            return;
        }

        int temp = input[l];
        input[l] = input[n-l-1];
        input[n-l-1] = temp;

        reverseArrayOnePointers(l+1, input);
    }

    private static void reverseArrayTwoPointers(int l, int r, int[] input){

        if(l>=r){
            return;
        }

        int temp = input[l];
        input[l] = input[r];
        input[r] = temp;

        reverseArrayTwoPointers(l+1, r-1, input);
    }
}
