package com.dudi.main;

public class Java8 {

	public static void main(String[] args) {
		Interf inter = () -> System.out.println("Hello");
		Interf2 inter2 = (n1, n2) -> System.out.println(n1+n2);
		inter.m1();
		
		Thread t1;
	}

}

@FunctionalInterface
interface Interf{
	public void m1();
}

@FunctionalInterface
interface Interf2{
	public void m1(int n1, int n2);
}

