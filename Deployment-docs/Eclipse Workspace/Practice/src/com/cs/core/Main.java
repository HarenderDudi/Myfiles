package com.cs.core;

import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
	
		Person p = new Person(10,"Harender");
		HashMap<Person, String> map = new HashMap<>();
		map.put(p, p.getName());
		
		System.out.println(map.get(p));
		
		p.setAge(20);
		
		System.out.println(map.get(p));
		
	}
	
	
	

}

class Person{
	private int age;
	private String name;
	
	public Person(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;  
        return result;
    }
 
    //Compare only account numbers
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (age != other.age && name != other.name)
            return false;
        return true;
    }
	
}






















//
//HashMap<PersonWithAge, String> map = new HashMap<>();
//List<PersonWithAge> employee = new ArrayList<>();
//employee.stream().collect(
//		Collectors.collectingAndThen(
//				Collectors.toCollection(() -> new TreeSet<>(Comparator.comparingInt(PersonWithAge::getAge))),
//				ArrayList::new));
//
//TreeSet<PersonWithAge> collect = employee.stream().collect(
//				Collectors.toCollection(() -> new TreeSet<>(Comparator.comparingInt(PersonWithAge::getAge))));
//
//
//class PersonWithAge {
//    String name;
//    Integer age;
//    
//    
//	public PersonWithAge(String name, Integer age) {
//		super();
//		this.name = name;
//		this.age = age;
//	}
//
//	public PersonWithAge returninstance(){
//		return null;
//	}
//	
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public Integer getAge() {
//		return age;
//	}
//	public void setAge(Integer age) {
//		this.age = age;
//	}
//      
//}
//
//class PersonWithAge2 extends PersonWithAge {
//	String name;
//    Integer age;
//    
//    public PersonWithAge2(String name, Integer age) {
//    	super(name, age);
//    }
//    
//    @Override
//    public PersonWithAge2 returninstance() {
//		return  null;
//	}
//
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public Integer getAge() {
//		return age;
//	}
//	public void setAge(Integer age) {
//		this.age = age;
//	}
//      
//}
