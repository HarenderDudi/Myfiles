package com.cs.main;

import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {

//		Toddler c = new Toddler();
//		c.m1();
//		
//		try {
//			if(null instanceof String) {
//			    System.out.println("ohhhohoho");
//			} else {
//			    System.out.println("Do the check");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		String s1 = new String("TCS");
		String s2 = "TCS";

		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		
		
	}
}

class Farm {
	  private List<Animal> animals;

	  public void addAnimals(Collection<Animal> newAnimals) {
	    animals.addAll(newAnimals);
	  }
}

class Animal {
	
}

class Dog extends Animal {}
class Cat extends Animal {}


class Parent implements Comparable{
	String name;
	
	Parent(String name){
		this.name = name;
	}
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
	@Override
	public int compareTo(Object o) {
		return 0;
	}
	
}

class Child extends Parent{
	
	Child(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

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
