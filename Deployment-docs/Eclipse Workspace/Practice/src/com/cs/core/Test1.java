package com.cs.core;

public class Test1 {

	static int a = 100000000;
	static int b = 200000000;
	int c=10;
	
	public static void main(String[] args) {
		System.out.println(a);
		System.out.println(b);
		//System.out.println(c);
		
		Test1 test1 = new Test1();
		//test1.test();
		System.out.println(test1.c);
	}
	
	private void test(){
		a = 1000;
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}
	
/*	@Override
	protected void finalize()throws Throwable{
		
	}*/

}
