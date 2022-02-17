package com.cs.stack;

import java.util.Stack;

public class ReverseStack {

	public static void main(String[] args) {

		Stack<Integer> s = new Stack<>();
		s.addElement(1);
		s.addElement(2);
		s.addElement(3);
		s.addElement(4);
		
		System.out.println(s);
		
		
		
	}
	
	private static void reverseStack(Stack<Integer> s) {
		int temp = s.pop();
		reverseStack(s);
	}

}
