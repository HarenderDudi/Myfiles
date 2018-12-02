package com.cs.core.polymorphism;

public class Example3_Private {

	public static void main(String[] args) {
		/*Parent2 p2 = new Child2();
		p2.m1();*/ 
		// output: parent
		
		Child2 c2 = new Child2();
		c2.m1();
		
	}

}

class Parent3 {
	private void m1(){
		System.out.println("Parent class");
	}
}

class Child3 extends Parent3{
	public void m1(){System.out.println("child class");}

}