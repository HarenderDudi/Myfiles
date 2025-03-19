package com.dudi.array;

public class MaxProductSubArray {

	public static void main(String[] args) {

		int[] input = new int[] {2,-1,-2,0,-1,10};
		int curr_max = input[0];
		int curr_min = input[0];
		int prev_max = input[0];
		int prev_min = input[0];
		int ans = input[0];
		
		System.out.println("curr_max\tcurr_min\tprev_max\tprev_min\tans");
		System.out.println("    "+curr_max +"\t\t"+ curr_min +" \t\t"+ prev_max +"\t\t"+ prev_min +"\t\t" + ans);
		
		for(int i=1; i<input.length; i++) {
			 curr_max = Math.max(Math.max(prev_max * input[i], prev_min * input[i]), input[i]);
			 curr_min = Math.min(Math.min(prev_max * input[i], prev_min * input[i]), input[i]);
			 ans = Math.max(ans, curr_max);
			 prev_max = curr_max;
			 prev_min = curr_min;
			 
			 System.out.println("    "+curr_max +"\t\t"+ curr_min +" \t\t"+ prev_max +"\t\t"+ prev_min +"\t\t" + ans);
			 
		}
		
		System.out.println("\n\n"+ ans);
		
	}

}
