package com.cs.main;

import java.util.ArrayList;
import java.util.List;

public class Generics {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("A");
		
		m1(list);
		
		System.out.println(list);

	}
	
	public static void m1(ArrayList<?> list){
		List<String> l2 = (List<String>) list;
		l2.add("B");
//		list.add("");
	}
	
	public static void m1(ArrayList<? extends Object> list, String s){
		//list.add("C");
	}

}
