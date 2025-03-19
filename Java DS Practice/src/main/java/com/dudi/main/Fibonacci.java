package com.dudi.main;

public class Fibonacci {

	public static void main(String[] args) {
		//System.out.println(calfib(5));
		display();

	}
	
	static int calfib(int n){
		if(n==0){
			return 0;
		}
		
		if(n==1){
			return 1;
		}

		return calfib(n-1) + calfib(n-2);
	}
	
	static void display(){
		int f1 = 0;
		int f2 = 1;
		
		for(int i=0; i<15;i++){
			System.out.println(f1);
			
			int sum = f1 +f2;
			f1= f2;
			f2= sum;
		}
	}

}
