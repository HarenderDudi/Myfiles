package com.cs.main;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		final List<String> list = new LinkedList();
		list.add("a");
		addInList(list);
		list.add(0, "c");
		
		for (String string : list) {
			System.out.println(string);
		}
		
		Hashtable ht= new Hashtable();
		Collections.synchronizedMap(new HashMap<>());
	}

	private static void addInList(List<String> list) {
		list.add("b");
	}

}
