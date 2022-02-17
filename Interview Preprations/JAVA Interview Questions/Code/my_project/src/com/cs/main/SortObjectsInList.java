package com.cs.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SortObjectsInList {
	public static void main(String[] args) {
		ArrayList<PersonList> list = new ArrayList<>();
		PersonList p1 = new PersonList();
		PersonList p2 = new PersonList();
		PersonList p3 = new PersonList();
		PersonList p4 = new PersonList();
		
		HashMap<String, String> map = new HashMap<>();
		System.out.println("MAAAP" + map.put("1", "1"));
		System.out.println("MAAAP" + map.put("1", "2"));
		
		
		setInfo(p1, 23, "AA");
		setInfo(p2, 22, "Ab");
		setInfo(p3, 21, "Ac");
		setInfo(p4, 20, "Ad");
		
		list.add(p1);
		list.add(p2);
		//Collections.sort(list);
		for (PersonList personList : list) {
			System.out.println(personList.getName() +"  --- "+ personList.getAge());
		}
		
		TreeSet<PersonList> treeSet = new TreeSet<>();
		treeSet.add(p1);
		treeSet.add(p2);
		treeSet.add(p3);
		for (PersonList personList : treeSet) {
			System.out.println(personList.getName() +"  --- "+ personList.getAge());
		}
		
	
				
	}
	
	private static void setInfo(PersonList p1, Integer age, String name) {
		p1.setAge(age);
		p1.setName(name);
	}
}

class PersonList /*implements Comparable<PersonList>*/{
	private Integer age;
	private String name;
	
	
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
/*	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}*/
	
/*	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}*/
	
	/*@Override
	public int compareTo(PersonList o) {
		return this.name.compareTo(o.getName());
	}*/
	

	
	
}