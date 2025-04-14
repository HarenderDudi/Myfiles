package com.dudi.sortingalgo;

public class QuickSort {
    public static void main(String args[]) {
        int arr[] = {12, 11, 0, 15, 5};
        int n = arr.length;

//        sort(arr, 0, n - 1);

        // sorting using strivers logic
        //https://www.youtube.com/watch?v=WIrA4YexLRQ&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=16
        quickSort(arr, 0, n - 1);

        System.out.println("sorted array");
        printArray(arr);
    }

    static void quickSort(int[] arr, int low, int high){

        if(low <= high){
            int pivot = findPivot(arr, low, high);
            quickSort(arr, low, pivot-1); // pivot is in right place, we need sorting elements from low to pivot-1
            quickSort(arr, pivot+1, high);// pivot is in right place, we need sorting elements from  pivot+1 to high
        }
    }

    static int findPivot(int[] arr, int low, int high){
        int pivot = low;
        int i=low;
        int j=high;

        // {12(p)(i), 11, 0, 15, 5(j)}
        // move i in right till we find element greater than pivot element
        // move j in left till we find element less than pivot element
        // if i<j then swap,
        // in end swap i and pivot

        while(i<j){
            while(arr[i]<= arr[pivot] && i<high){
                i++;
            }
            while (arr[j] > arr[pivot] && j>low){
                j--;
            }

            if(i<j){
                // swap so that elements less than pivot are on left side of pivot and vice versa
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[j];
        arr[j] = arr[pivot];
        arr[pivot] = temp;

        return j;
    }


    static void sort(int arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }
    static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        i++;
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;

        return i;
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
