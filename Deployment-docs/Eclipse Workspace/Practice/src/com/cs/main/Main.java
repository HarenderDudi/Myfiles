package com.cs.main;

public class Main {

	public static void main(String[] args) {

//		Toddler c = new Toddler();
//		c.m1();
		
		try {
			if(null instanceof String) {
			    System.out.println("ohhhohoho");
			} else {
			    System.out.println("Do the check");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

class Parent{
	
	public void m1() {
		System.out.println("Parent m1");
		m2();
		m3();
	}
	
	public void m2() {
		System.out.println("Parent m2");
	}
	
	public void m3() {
		System.out.println("Parent m3");
	}
	
}

class Child extends Parent{
	
	@Override
	public void m3() {
		System.out.println("Child m3");
	}
}

class Toddler extends Child{
	@Override
	public void m2() {
		System.out.println("Toddler m2");
	}
}
