package com.cs.core.polymorphism;

public class Example1 {

	public static void main(String[] args) {
		System.out.println(new Child().m1());
	}

}

class Parent{
	Animal m1(){
		System.out.println("Parent class");
		return new Dog();
	}
}

class Child{
	Dog m1(){
		System.out.println("child class");
		return new Dog();
	}

}

class Animal {}

class Dog extends Animal{}
