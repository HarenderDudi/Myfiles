package com.cs.core.generics;

public class Example1_ArrayOfString {

	public static void main(String[] args) {

		String[] ary = new String[10];
		ary[0] = "hehe";
		//ary[1] = 1; // cant cast int to string
		ary[1] = new Integer(10).toString();
	}

}
