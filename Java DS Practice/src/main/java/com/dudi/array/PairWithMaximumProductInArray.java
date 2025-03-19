package com.dudi.array;

public class PairWithMaximumProductInArray {

	public static void main(String[] args) {

		int[] arr = {1,-5,3,-3,0,5,-1,-4,2};
		int size = arr.length;
		if(size < 2) {
			System.out.println("Invalid array");
		}
		
		if(size==2) {
			System.out.println(arr[0] + " " + arr[1]);
		}
		
		 // Initialize maximum and second maximum
        int maxa = Integer.MIN_VALUE,
            maxb = Integer.MIN_VALUE;
      
        // Initialize minimum and second minimum
        int mina = 0,
            minb = 0;
      
        // Traverse given array
        for (int i = 0; i < size; i++)
        {
        	if(arr[i] > maxa) {
        		maxb = maxa;
        		maxa = arr[i];
        	} else if(arr[i] > maxb) {
        		maxb = arr[i];
        	}
        	
        	if(arr[i] < mina) {
        		minb = mina;
        		mina = arr[i];
        	} else if(arr[i] < minb) {
        		minb = arr[i];
        	}
        }

        System.out.println(maxa + "--max--" + maxb);
        System.out.println(mina + "--min--" + minb);
        
        if (mina * minb > maxa * maxb)
            System.out.println("Max product pair is {"
                          + mina + ", " + minb + "}");
        else
            System.out.println("Max product pair is {"
                          + maxa + ", " + maxb + "}");
        
	}

}
