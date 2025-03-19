package com.dudi.streams;

import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamTests {

    @Test
    public void filterStringOnLengthTest(){
        List<String> names = List.of("Rama", "Poonma Ram Ji", "4444", "55555", "666666");
        names.stream().filter(n-> n.length()>=5).forEach(System.out::println);
    }

    @Test
    public void sumIntegersTest(){
        List<Integer> numbers = List.of(5, 6, 1, 99, 10);
        System.out.println(numbers.stream().filter(n->n%2==0).reduce(0, Integer::sum));
    }

    @Test
    public void upperCaseTest(){
        List<String> words = List.of("java", "streams", "are", "fun");
        List<String> outputList = words.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(outputList);
    }

    @Test
    public void findMaxIntTest(){
        List<Integer> numbers = List.of(5, 12, 3, 21, 8);
        Integer output = numbers.stream().reduce(Integer.MIN_VALUE, (a, b) -> Integer.max(a, b));;
        System.out.println(output);

        // Improved version
        Integer output2 = numbers.stream().reduce(Integer.MIN_VALUE, Integer::max);
    }

    @Test
    public void countStartsWithATest(){
        List<String> names = List.of("Alice", "Bob", "Anna", "Alex", "Brian", "amma");
        Long output = names.stream().filter(s->s.toLowerCase().startsWith("a")).count();
        System.out.println(output);
    }

    @Test
    public void findSquareTest(){
        List<Integer> numbers = List.of(2, 3, 4, 5);
        List<Integer> output = numbers.stream()
                .map(n->n*n)
                .collect(Collectors.toList());
        System.out.println(output);
    }

    @Test
    public void findLongestStringTest(){
        List<String> words = List.of("apple", "banana", "cherry", "date");
        Optional<String> first = words.stream().max(Comparator.comparing(String::length));
        System.out.println(first.get());
    }

    @Test
    public void removeDuplicateIntTest(){
        List<Integer> numbers = List.of(5, 3, 7, 5, 3, 8, 9);
        List<Integer> integers = numbers.stream().distinct().sorted().toList();
        System.out.println(integers);
        Optional.of("").orElse()
    }

    @Test
    public void joinStringTest(){
        List<String> words = List.of("apple", "banana", "cherry", "date");
        String collect = words.stream().collect(Collectors.joining(", "));
        System.out.println(collect);
        Function<String, Integer> stringIntegerFunction = String::length;
    }

    @Test
    public void doubleIntGreaterThan10Test(){
        List<Integer> numbers = List.of(4, 15, 8, 10, 20, 7);
        List<Integer> integers = numbers.stream().filter(n -> n <= 10).map(n -> n + n).toList();
        System.out.println(integers);
    }

    @Test
    public void filterAndIncrementOperationTest(){
        List<Employee> employees = List.of(
                new Employee("Alice", 45000),
                new Employee("Bob", 55000),
                new Employee("Charlie", 60000),
                new Employee("David", 40000),
                new Employee("Eve", 70000)
        );

        List<Employee> employees1 = employees.stream()
                .filter(e -> e.getSalary() > 50000)
                .map(e -> {
                    double salary = e.getSalary();
                    salary += salary * .10;
                    return new Employee(e.getName(), salary);
                }).toList();

        System.out.println(employees1);
    }

    @Getter
    @Setter
    static class Employee {
        String name;
        double salary;

        public Employee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return name + " - " + salary;
        }
    }
}
