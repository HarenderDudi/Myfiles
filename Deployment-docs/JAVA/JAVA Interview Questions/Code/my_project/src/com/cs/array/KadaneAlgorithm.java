package com.cs.array;

public class KadaneAlgorithm {

	public static void main(String[] args) {
		int a[] = { -2, -3, 4, -1, -4, 1, 5, -3 };

		int local_max = 0;
		int global_max = 0;
		int start = -1;
		int end = -1;
				
				
		//global_max = dynamicPrograming(a, global_max);
		
		local_max = a[0];
		for (int i = 1; i < a.length; i++) {
			local_max = local_max + a[i];
			
			if(local_max < 0){
				local_max = 0;
				start = i+1;
			}
			
			if(global_max < local_max){
				global_max = local_max;
				
				end = i;
			}
		}
		
		System.out.println(global_max + "---" + ++start + "-"+ ++end);
	}

	private static int dynamicPrograming(int[] a, int global_max) {
		int local_max;
		local_max = a[0];
		for (int i = 1; i < a.length; i++) {
			local_max = Math.max(a[i], local_max + a[i]);
			System.out.println("i: " + i + "\t max:" + local_max);
			if(global_max < local_max){
				global_max = local_max;
			}
		}
		return global_max;
	}

}
