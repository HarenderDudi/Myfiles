package com.cs.core.polymorphism;

public class Example4_Abstract {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Child4 extends Parent4 {

	@Override
	public void m2() {
		
	}
	
}

abstract class Parent4 implements IParent {
 public abstract void m2();
 
	@Override
	public void m1() {
		
	}
 
}

interface IParent {
	void m1();
}
