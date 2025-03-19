package com.dudi.array;

public class StockBuySellOneTransaction {

	public static void main(String[] args) {

//		int[] arr = {3,10,1,7,9,4,2};
		int[] arr = {1, 2, 90, 10, 110};
		int maxProfit = 0;
		int minPrice = arr[0];
		
		for(int i = 1; i < arr.length ; i++) {
			int currentProfit = arr[i] - minPrice;
			if(currentProfit > maxProfit) {
				maxProfit = currentProfit;
			}
			
			if(arr[i] < minPrice) {
				
				minPrice = arr[i];
			}
		}
		
		System.out.println(maxProfit);
	}
	
//	int profit = 0;
//	int mimimumPrice = price[0];
//	for(int i=1; i< prices.length; i++) {
//		profit = Math.max(profit, prices[i]-minimumPrice);
//		minimumPrice = Math.min(minimumPrice, prices[i]);
//	}

}
