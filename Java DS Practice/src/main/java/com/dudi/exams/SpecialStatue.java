package com.dudi.exams;

public class SpecialStatue {

	public static void main(String[] args) {
		//int[] A = {8,8,5,1,1,10,5,5,9,9,9,3};
		//int[] B = {65,6,46,82,28,62,92,96,43,28,37,92};
		
		int[] A = {2,1,1,3,4};
		int[] B = {3,3,5,3,10};
		
		SpecialStatue st= new SpecialStatue();
		int res = st.solve(A, B);
		System.out.println(res);
		
	}
	
	public int solve(int[] A, int[] B) {

		int totalCost = 0;
		int lenA = A.length;
		int lenB = B.length;

		if (lenA != lenB) {
			System.out.println("Size should be same for both array");
			return -1;
		}

		for (int i = 0; i < lenA - 2; i++) {
			int j = i + 1;

			// check if A[i] == A[j]
			if (A[i] == A[j]) {

				// check who's price is less
				// if price of j status is less increase size by 1
				if (B[j] < B[i]) {
					totalCost = totalCost + B[j];
					A[j] = A[j] + 1;
				} else {
					// if i is first statue then increase size and add its price
					// to totalCost
					if (i == 0) {
						totalCost = totalCost + B[i];
						A[i] = A[i] + 1;
						continue;
					}

					// check if after increasing size of ith statue, it should
					// not be equal to ith-1 status
					// if yes check price with jth statue after increasing price
					// of ith by 2 times
					if (A[i] + 1 == A[i - 1]) {

						if (B[j] < B[i] * 2) {
							totalCost = totalCost + B[j];
							A[j] = A[j] + 1;
						} else {
							totalCost = totalCost + (B[i] * 2);
							A[i] = A[i] + 2;
						}
					}
					// increase size of ith statue and add price
					else {
						totalCost = totalCost + B[i];
						A[i] = A[i] + 2;
					}

				}
			}

		}
		return totalCost;
	}

}
