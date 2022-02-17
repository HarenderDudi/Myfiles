package com.cs.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


public class StreamTest1 {

	public static void main(String[] args) {

		
		List<Person> list = new ArrayList<Person>();
		list.add(new Person(30, "Imran", "MH"));
		list.add(new Person(31, "Akash", "UP"));
		list.add(new Person(32, "Balmukund", "UP"));
		list.add(new Person(29, "Sawan", "MH"));
		list.add(new Person(30, "Harender", "RJ"));

		
		Comparator<Person> comp = (Person p1, Person p2) -> {
			int l1 = p1.getName().length();
			int l2 = p2.getName().length();
			int result = Integer.compare(l1, l2);
			if(result == 0) {
				return p1.getAge().compareTo(p2.getAge());
			}
			
//			Comparator.comparing(Person::getAge);
			return result;
			
		};
		
		 list.stream().map(Person::getName).forEach(System.out::println);
//		for(String ss : s) {
//			System.out.println(s);
//		}
		//list.stream().sorted(Comparator.comparing(Person::getName)).collect(Collectors.toList()).forEach(p -> System.out.println(p.getName()));
		
		// list.stream().collect()
		Map<String, List<Person>> peopleByCity = list.stream().collect(Collectors.groupingBy(Person::getCity));
		
		
		List<String> al = List.of("Geek_First", "Geek_2", "Geek_3", "Geek_4", "Geek_Last");
		
		String findFirst = al.stream().findFirst().orElse(null);
		String findLast = al.stream().skip(al.size()-1).findFirst().orElse(null);
		
		
		
		// find duplicate in list
		// 1. using filter and set
		// 2. using frequency
		
		List<Integer> lst2 = Arrays.asList(5, 13, 4, 21, 13, 27, 2, 59, 59, 34);
		Set<Integer> items = new HashSet<>();
		
		lst2.stream().filter(i -> !items.add(i)).collect(Collectors.toSet());
		lst2.stream().filter(i -> Collections.frequency(lst2, i) > 1).collect(Collectors.toSet());
		
		
		
		// find occurrence count of char in string
		String str1 = "geeksforgeeks";
		char ch = 'e';
		//System.out.println(str1.chars().filter(c -> c == ch).count());
		
		
		// stream.collect(Collectors.toList())
		// stream.collect(Collectors.toCollection(ArrayList::new))
	}

}

class Person{
	private Integer age;
	private String name;
	private String city;
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Person(Integer age, String name, String city) {
		super();
		this.age = age;
		this.name = name;
		this.city = city;
	}
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
	
	
	
}
