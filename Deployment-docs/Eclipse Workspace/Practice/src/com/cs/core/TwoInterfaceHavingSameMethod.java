package com.cs.core;

public class TwoInterfaceHavingSameMethod extends astractClass implements Interface1, Interface2{

	public static void main(String[] args) {

	}

	@Override
	public void method1() {
		
	}

}

abstract class astractClass implements Interface1, Interface2{
	public abstract void method1();
}

interface Interface1 {
	public void method1();
}

interface Interface2 {
	public void method1();
}
