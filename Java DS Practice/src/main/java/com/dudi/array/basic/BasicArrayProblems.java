package com.dudi.array.basic;

public class BasicArrayProblems {

    // Contains Easy and medium problems from Strivers playlist
    public static void main(String[] args) {

//        https://www.youtube.com/watch?v=37E9ckMDdTk&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=17&pp=iAQB

//        SecondLargestElementInArray();
//        removeDuplicateFromSortedArray();

//        https://www.youtube.com/watch?v=wvcQg43_V8U&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=18
//        leftRotateTheArrayByKPlaces();
//        moveZerosToEnd();
//        unionOfTwoSortedArray();

//        https://www.youtube.com/watch?v=UXDSeD9mN-k&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=21
//        twoSum -> better->> map , optimal -> sort and greedy by two pointer

//        https://www.youtube.com/watch?v=tp8JIuCXBaU&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=22
//        sortArrayOf0s1s2s();

    }

    private static void SecondLargestElementInArray() {
        int[] arr = {8,2,4,7,7,5};
        int largest = arr[0];
        int secondLargest = -1;

        for(int i =1; i<arr.length; i++){
            if(arr[i] > largest){
                secondLargest = largest;
                largest = arr[i];
            } else if(arr[i] < largest && arr[i] > secondLargest) {
                secondLargest = arr[i];
            }
        }

        System.out.println(secondLargest);
    }

    private static void removeDuplicateFromSortedArray() {
        int[] arr = {1,1,2,2,2,3,3,5};

        int i = 0;
        for(int j =1; j<arr.length; j++){
            if(arr[j] != arr[i]){
                arr[++i] = arr[j];
            }
        }
        System.out.println(i+1);

    }

    private static void leftRotateTheArrayByKPlaces() {
        // time complexity: O(2N)
//        int[] arr = {1,2,3,4,5,6};
        int[] arr = {1,2,3,4,5,6,7};
        int k = 2;

        // expectation: {3,4,5,6,7,1,2}

        // logic: for left rotate
        // reverse from 0 to (k % arr.length) - 1{2,1,3,4,5,6,7} || 2 % 7 = 2
        // reverse from k % arr.length to arr.length {2,1,7,6,5,4,3} || 2 % 7 = 2
        // reverse the array {3,4,5,6,7,1,2}

        int start = 0;
        int end = arr.length - 1;

        int rotationEnd = (k % arr.length);
        swapArray(arr, start, rotationEnd -1);
        printArray(arr);

        swapArray(arr, rotationEnd, end);
        printArray(arr);

        swapArray(arr,start, end);
        printArray(arr);


    }

    private static void moveZerosToEnd() {
        // time complexity = O(N)
        int[] arr = {1,0,2,3,2,0,0,4,5,1};
        // find the first zero and move i to that index
        // from j=i+1 to arr-1, if arr[j] !=0; swap i&j, i++

        int i = -1;
        int j = 0;
        while(j < arr.length){
            if(arr[j]==0) {
                i = j;
                break;
            }
            j++;
        }



        for(j=i+1; j < arr.length; j++){
            if(arr[j] != 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }

        printArray(arr);
    }

    private static void unionOfTwoSortedArray() {
        // time complexity = O(N)
//        int[] arr1 = {1,1,2,3,4,5};
//        int[] arr2 = {2,3,4,4,5,6,9};

        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {5,6,7,8,9};

        int[] union = new int[arr1.length+ arr2.length];

        int i = 0;
        int j = 0;
        int k = 0;
        while(i<arr1.length && j < arr2.length){
            if(arr1[i]<=arr2[j]){
                if(k==0 || union[k-1]!=arr1[i]){
                    union[k++] = arr1[i];
                }
                i++;
            } else {
                if(k==0 || union[k-1]!=arr2[j]){
                    union[k++] = arr2[j];
                }
                j++;
            }
        }

        while (i < arr1.length){
            union[k] = arr1[i];
            i++;
            k++;
        }

        while (j < arr2.length){
            union[k] = arr2[j];
            j++;
            k++;
        }

        printArray(union);
    }

    private static void sortArrayOf0s1s2s() {
        int[] arr = {0,1,1,0,1,2,1,2,0,0,0};
        int low = 0;
        int mid = 0;
        int high = arr.length-1;

       while(low<high){
            if(arr[mid]==0){
                swapArray(arr,low,mid);
                low++;
                mid++;
            } else if(arr[mid]==1){
                mid++;
            } else {
                swapArray(arr,mid,high);
                high--;
            }
        }

       printArray(arr);
    }
    private static void swapArray(int[] arr, int start, int end) {
        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start ++;
            end --;
        }
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }



}
