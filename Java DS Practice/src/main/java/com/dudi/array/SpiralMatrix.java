package com.dudi.array;

public class SpiralMatrix {

	public static void main(String[] args) {

//		 int a[][] = {  { 1, 2, 3 },
//				 		{ 4, 5, 6 },
//				 		{ 7, 8, 9 } 
//				 	 };
		 
		 int a[][] = { { 1, 2, 3, 4 },
				 	   { 5, 6, 7, 8 },
				 	   { 9, 10, 11, 12 },
				 	   { 13, 14, 15, 16 } };

		 
		 
		 spiralPrintMethod2(a);
		
	}

	
	
	static void spiralPrintMethod1(int rH, int cH, int a[][])
    {
        int i, rL = 0, cL = 0;
 
        /*  rL - starting row index
        rH - ending row index
        cL - starting column index
        cH - ending column index
        i - iterator
        */
 
        while (rL < rH && cL < cH) {
            // Print the first row from the remaining rows
            for (i = cL; i < cH; ++i) {
                System.out.print(a[rL][i] + " ");
            }
            rL++;
 
            // Print the last column from the remaining
            // columns
            for (i = rL; i < rH; ++i) {
                System.out.print(a[i][cH - 1] + " ");
            }
            cH--;
 
            // Print the last row from the remaining rows */
            if (rL < rH) {
                for (i = cH - 1; i >= cL; --i) {
                    System.out.print(a[rH - 1][i] + " ");
                }
                rH--;
            }
 
            // Print the first column from the remaining
            // columns */
            if (cL < cH) {
                for (i = rH - 1; i >= rL; --i) {
                    System.out.print(a[i][cL] + " ");
                }
                cL++;
            }
        }
    }
	
	private static void spiralPrintMethod2(int[][] a) {
		int il = 0;
		 int jl = 0;
		 int jh = 3;
		 int ih = 3;
		 
		 int i = 0;
		 int j = 0;
		 
		while(il<=ih) {
			 if(i==il && j == jl) {
				 while(j <= jh) {
					 System.out.print(a[i][j] + "-");
					 j++;
				 }
				 j--;
			 }
			 
			 System.out.println();
			 if(j == jh && i == il) {
				 i++;
				 while(i <= ih) {
					 System.out.print(a[i][j]+ "-");
					 i++;
				 }
				 i--;
				 il++;
			 }
			 
			 System.out.println();
			 if(i==ih && j ==jh) {
				 j--;
				 while(j >= jl) {
					 System.out.print(a[i][j]+ "-");
					 j--;
				 }
				 j++;
				 jh--;
			 }
			 
			 System.out.println();
			 if(i == ih && j== jl) {
				 i--;
				 while(i >= il) {
					 System.out.print(a[i][j]+ "-");
					 i--;
				 }
				 i++;
				 j++;
				 ih--;
				 jl++;
			 }
		}
	}

}
