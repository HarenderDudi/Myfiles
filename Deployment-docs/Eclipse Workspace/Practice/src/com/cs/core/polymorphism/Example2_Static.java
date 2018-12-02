package com.cs.core.polymorphism;

public class Example2_Static {

	public static void main(String[] args) {
		/*Parent2 p2 = new Child2();
		p2.m1();*/ 
		// output: parent
		
		Child2 c2 = new Child2();
		c2.m1();
		
	}

}

class Parent2 {
	static void m1(){
		System.out.println("Parent class");
	}
}

class Child2 extends Parent2{
	static void m1(){System.out.println("child class");}

}

// ----------------------------------------------------------
/*class Parent2 {
	private void m1(){
		System.out.println("Parent class");
	}
}

class Child2 extends Parent2{
	static void m1(){System.out.println("child class");}

}*/
// -----------------------------------------------------------


/*class Parent2 {
	void m1(){
		System.out.println("Parent class");
	}
}

class Child2 extends Parent2{
	static void m1(){System.out.println("child class");} // Exception: This static method cannot hide the instance method from Parent2

}*/

/*class Parent2 {
	static void m1(){
		System.out.println("Parent class");
	}
}

class Child2 extends Parent2{
	void m1(){System.out.println("child class");} // Exception: This instance method cannot override the static method from Parent2

}*/