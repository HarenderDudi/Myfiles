package com.cs.main;

public class StaticExtends {
	public static void main (String[] args) {
		System.out.println(ClassB.validString);	
	}
}

class ClassA {
	
	protected static String validString = null;
	
	static {
		validString = "Class A";
	}
}


class ClassB extends ClassA {
	
//	private static String validString = null;
//	
//	static {
//		validString = "Class B";
//	}
}

