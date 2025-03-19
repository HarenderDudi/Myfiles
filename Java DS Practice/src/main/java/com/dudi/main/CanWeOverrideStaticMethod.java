package com.dudi.main;

import java.util.HashSet;

public class CanWeOverrideStaticMethod {
	 
    public static void main(String args[]) {
     
        Screen scrn = new ColorScreen();
     
        scrn.show(); 
        HashSet<String> s = new HashSet<>();
    } 
 
}

class Screen{
 
    public static void show(){
        System.out.printf("Static method from parent class");
    }
    
}

class ColorScreen extends Screen{
    
	public static void show(){
        System.err.println("Overridden static method in Child Class in Java");
    }
	
	
	// Compile time error
	
//	public void show(){
//		System.out.println("Child class show method");
//	}
}
