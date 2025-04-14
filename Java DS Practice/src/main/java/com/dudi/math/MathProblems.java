package com.dudi.math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MathProblems {
    public static void main(String[] args) {
//        https://www.youtube.com/watch?v=1xNbjMdbjug&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=9
//
//        countDigits();
//        reverseNumber();
//        checkIfNumberPalindrome();

//        armstrongNumber(); // a number whose sum of cube of digits is equal to original number, 371 = 3^3 + 7^3 + 1^3
//        printDivisors();

//        GCD() // euclidean algorithm gcd(a,b) = gcd(a-b,b) if (a>b)
//        GCD();


    // print 3 2 1 without i-1
    }


    private static void GCD() {
        // time complexity is log(min(a,b))
        int a = 52;
        int b = 10;

        while(a>0 && b>0){
            if(a>b){
                a = a%b;
            } else {
                b = b%a;
            }
        }

        if(a>0){
            System.out.println(a);
        } else
            System.out.println(b);
    }

    private static void printDivisors() {
        // Time complexity is [O(sqrt(n)) + nlogn] nlogn for (sorting)
        int n = 36;
        List<Integer> divisors = new ArrayList<>();

        for(int i =1; i <= Math.sqrt(n) ; i++){
           if(n%i == 0){

               divisors.add(i);
               if(i != (n/i)){
                   divisors.add(n/i);
               }
           }
        }

        divisors.sort(Comparator.naturalOrder());
        System.out.println(divisors);
    }

    private static void armstrongNumber() {
        int n = 371;
        int dup = n;
        int sum = 0;

        while(n>0){
            int lastDigit = n%10;
            n = n/10;
            sum = sum + (lastDigit * lastDigit * lastDigit);
        }

        if(sum == dup){
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

    private static void countDigits() {
        // time complexity: O(log base 10 (n))
        // log base 10 bcz number is divided by 10, if number is divided by 5 then log base 5 etc

        int n = 328391;
        int count = 0;

        while ( n > 0) {
            n = n/10;
            count++;
        }

        System.out.println("method1: " + count);

        int n1 = 328391;
        System.out.println("method2: " + (int) (Math.log10(n1) + 1));
    }

    private static void reverseNumber() {
        // time complexity: O(log base 10 (n))
        // log base 10 bcz number is divided by 10, if number is divided by 5 then log base 5 etc
//        int n = 328391;
        int n = 10400; // ans should be 401
        int reversed = 0;

        while(n>0){
            int lastDigit = n%10;
            n = n/10;
            reversed = reversed * 10 + lastDigit;
        }

        System.out.println(reversed);
    }

    private static void checkIfNumberPalindrome() {
        int n = 1221;
        int nCopy = n;
        int reversed = 0;

        while(n>0){
            int lastDigit = n%10;
            n = n/10;
            reversed = reversed*10+lastDigit;
        }

        if(reversed == nCopy){
            System.out.println(true);
        }
        else {
            System.out.println(false);
        }
    }


}


