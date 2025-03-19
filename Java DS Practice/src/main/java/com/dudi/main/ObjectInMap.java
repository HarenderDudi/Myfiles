package com.dudi.main;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ObjectInMap {
	public static void main(String[] args) {
		
		ExecutorService executor = Executors.newFixedThreadPool(10);
		Map<String, String> map2 = new HashMap<>();
		map2.put("1", "1");
		map2.put("2", "2");
		map2.put("3", "3");
		map2.put("4", "4");
		Map<Person, Integer> map = new HashMap<Person, Integer>();
		Person p1 = new Person();
		Person p2 = new Person();
		Person p3 = new Person();
		Person p4 = new Person();
		
		setInfo(p1, 23, "AA");
		setInfo(p2, 22, "Ab");
		setInfo(p3, 21, "Ac");
		setInfo(p4, 20, "Ad");
		
		map.put(p1, 1);
		map.put(p2, 2);
		map.put(p3, 3);
		map.put(p4, 4);
		for (Entry<String, String> entry: map2.entrySet()) {
			System.out.println(entry.getValue());
		}
		
		for (Entry<Person, Integer> entry: map.entrySet()) {
			Person person = entry.getKey();
			System.out.println(entry.getValue() + " -- " + person.getName() + " -- " + person.hashCode());
		}
		
		/*TreeMap<Person, Integer> treeMap = new TreeMap<>();
		treeMap.put(p1, 1);
		treeMap.put(p2, 2);
		treeMap.put(p3, 3);
		treeMap.put(p4, 4);
		System.out.println("tree map size  : " + treeMap.size());
		
		treeMap.forEach((k,v) -> {
			Person person = k;
			System.out.println("--------- Tree Map -----------");
			System.out.println(v + " -- " + person.getName() + " -- " + person.hashCode());
		});*/
	}

	private static void setInfo(Person p1, Integer age, String name) {
		p1.setAge(age);
		p1.setName(name);
	}
}


class Person /*implements Comparable<Person>*/{
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
	public int compareTo(Person o) {
		return this.name.compareTo(o.getName());
	}*/
	

	
	
}



class RatingCompare implements Comparator<Person>
{
    public int compare(Person m1, Person m2)
    {
        if (m1.getAge() < m2.getAge()) return -1;
        if (m1.getAge() > m2.getAge()) return 1;
        else return 0;
    }
}
 
// Class to compare Movies by name
class NameCompare implements Comparator<Person>
{
    public int compare(Person m1, Person m2)
    {
        return m1.getName().compareTo(m2.getName());
    }
}
