package com.cs.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class SortEmpByAge {

	public static void main(String[] args) {
		
		PersonWithAge alex = new PersonWithAge("Alex", 23);
	    PersonWithAge john = new PersonWithAge("John", 40);
	    PersonWithAge peter = new PersonWithAge("Peter", 32);
	    PersonWithAge peter50 = new PersonWithAge("Peter50", 50);
	    PersonWithAge peter60 = new PersonWithAge("Peter60", 60);
	    List<PersonWithAge> people = Arrays.asList(alex, john, peter, peter50, peter60);

	    PersonWithAge minByAge = people
	      .stream()
	      .min(Comparator.comparing(PersonWithAge::getAge))
	      .orElseThrow(NoSuchElementException::new);
	    
	    PersonWithAge minByAge2 = people.stream().sorted(Comparator.comparingInt(PersonWithAge::getAge)).limit(3).skip(2).findFirst().get();
	    
	    System.out.println(minByAge.getName() + " -- " + minByAge.getAge());
	    System.out.println(minByAge2.getName() + " -- " + minByAge2.getAge());
		
	}

}

class PersonWithAge {
    String name;
    Integer age;
    
    
	public PersonWithAge(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
      
}
