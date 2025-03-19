package com.dudi.array;

public class SquareRoot {

	public static void main(String[] args) {
		int x = 9;
		if (x == 0 || x == 1) 
			System.out.println(x);; 

		int start = 1, end = x, ans=0; 
		while (start <= end) { 
			int mid = (start + end) / 2; 

			if (mid <= x/mid) {  // mid * mid might cause overflow
				start = mid + 1; 
				ans = mid;       // if mid^2 < x then it is possible answer 
			} else {
				end = mid-1;                 
			} 
		} 
		
		System.out.println(ans);
		
	}

}
