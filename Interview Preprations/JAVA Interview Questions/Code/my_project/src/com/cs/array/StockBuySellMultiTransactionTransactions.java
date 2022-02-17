package com.cs.array;

public class StockBuySellMultiTransactionTransactions {

	public static void main(String[] args) {

//		int[] arr = {3,10,1,7,9,4,2}; // 1-2, 3-5 | 3-10, 1-9
//		int[] arr = { 7, 1, 5, 3, 6, 4 }; 1-6
		int[] arr = { 100, 180, 260, 310, 60, 50, 40, 535, 695, 30 }; // 1-4, 5-8 | 100-310, 40-695
		int maxProfit = 0;
		int minPrice = arr[0];
		
		boolean buy = false;
		boolean sell = false;
		
		// for total profit we can do as below
		
//		int totalProfit = 0;
//
//		for(int i=1; i< prices.length; i++) {
//			int currentProfit = prices[i]-price[i-1]);
//			if(currentProfit > 0)
//				totalProfit += currentProfit;
//		}
		
		
		for(int i = 1; i < arr.length ; i++) {
			int currentProfit = arr[i] - minPrice;
			if(currentProfit > maxProfit) {
				if(!buy) {
					buy = true;
					sell = false;
					System.out.println("Buy At: " + arr[i-1]);
				}
				maxProfit = currentProfit;
			}
			
			if(arr[i] < minPrice) {
				if(!sell) {
					System.out.println("Sell At: " + arr[i-1]);
				}
				minPrice = arr[i];
				buy = false;
				sell = true;
				maxProfit = 0;
			}
		}
		
		if(!sell) {
			System.out.println("Sell At: " + arr[arr.length-1]);
		}
	}

}
