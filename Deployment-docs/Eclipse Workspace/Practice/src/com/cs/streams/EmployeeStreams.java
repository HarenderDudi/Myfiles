package com.cs.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmployeeStreams {

	public static void main(String[] args) {

		List<Employee> list = new ArrayList<>();
		list.add(new Employee(101, "Santosh", 101, "active", 1200));
		list.add(new Employee(102, "Rohit", 101, "active", 2200));
		list.add(new Employee(103, "Harender", 101, "inactive", 2600));
		list.add(new Employee(104, "Raj", 101, "inactive", 2400));
		list.add(new Employee(105, "Sawan", 102, "inactive", 3200));
		list.add(new Employee(106, "Renu", 102, "active", 1400));
		list.add(new Employee(107, "Apurva", 103, "active", 3400));
		list.add(new Employee(108, "Shital", 103, "active", 900));
		list.add(new Employee(109, "Swapnil", 103, "inactive", 1000));
		
		// to print emp details based on dept
		
		Map<Integer, List<Employee>> collect = list.stream().collect(Collectors.groupingBy(Employee::getDeptId));
		
		collect.entrySet().forEach(e -> {
			System.out.print(e.getKey() + " --- ");
			e.getValue().stream().forEach(emp -> System.out.print(emp.getName() + ", "));
			System.out.println();
		});
		
		
		// get emp count from each dept
		Map<Integer, Long> collect2 = list.stream().collect(Collectors.groupingBy(Employee::getDeptId, Collectors.counting()));
		
		
		// get active employees
		//list.stream().filter(e -> e.getStatus().equals("active")).collect(Collectors.toList()).forEach(System.out::println);
		
		// find max salary
		//list.stream().max(Comparator.comparing(Employee::getSalary)).ifPresent(e -> System.out.println(e.getName() + " -- "+ e.getSalary()));;
		
		
		// find max salary dept wise
		Map<Integer, Employee> collect3 = list.stream().collect(Collectors.toMap(Employee::getDeptId, Function.identity(), BinaryOperator.maxBy(Comparator.comparing(Employee::getSalary))));
		collect3.entrySet().forEach(System.out::println);
		
		
		// get 3rd highest salary
		Employee e = list.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(2).findFirst().get();
//		System.out.println(e.getName() + " -- "+ e.getSalary());
	}

}
