package Streams_01;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamPractice {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee(1, "Ravi", "IT", "Developer", 55000, 28, "M", "Hyderabad",
                        List.of("Java", "Spring"), LocalDate.of(2021, 3, 15), false, 4.2, "Alpha"),
                new Employee(2, "Sneha", "HR", "Manager", 72000, 34, "F", "Chennai",
                        List.of("Recruiting", "Excel"), LocalDate.of(2018, 6, 1), true, 4.7, "Beta"),
                new Employee(3, "Kiran", "IT", "Manager", 95000, 39, "M", "Hyderabad",
                        List.of("Java", "AWS", "Docker"), LocalDate.of(2016, 1, 20), true, 4.9, "Alpha"),
                new Employee(4, "Divya", "Finance", "Analyst", 48000, 25, "F", "Bangalore",
                        List.of("Excel", "SQL"), LocalDate.of(2023, 9, 10), false, 3.8, "Gamma"),
                new Employee(5, "Arjun", "IT", "Developer", 60000, 30, "M", "Bangalore",
                        List.of("Java", "React"), LocalDate.of(2020, 11, 5), false, 4.0, "Beta"),
                new Employee(6, "Meera", "HR", "Executive", 40000, 24, "F", "Chennai",
                        List.of("Excel"), LocalDate.of(2024, 2, 1), false, 3.5, "Gamma"),
                new Employee(7, "Vikram", "Finance", "Manager", 88000, 41, "M", "Hyderabad",
                        List.of("Excel", "SAP"), LocalDate.of(2015, 4, 12), true, 4.6, "Alpha")
        );

        // types of ways to create a stream
        // From a Collection
        Stream<Employee> s1 = employees.stream();

        // From an array
        String[] arr = {"a", "b", "c"};
        Stream<String> s2 = Arrays.stream(arr);

        // Using Stream.of
        Stream<Integer> s3 = Stream.of(1, 2, 3);

        // Infinite stream
        Stream<Integer> s4 = Stream.iterate(1, n -> n + 1);   // 1,2,3,4...
        Stream<Double> s5 = Stream.generate(Math::random);


        // getting the employee sal based on department and sal and names by big to small
        // FILTER, SORTED, COMPARATOR
        employees
                .stream()
                .filter(e -> e.getSalary() > 50000)
                .sorted(
                        Comparator.comparing(Employee::getDepartment)
                                .thenComparing(Comparator.comparing(Employee::getSalary).reversed())
                                .thenComparing(Comparator.comparing(Employee::getName).reversed())
                )
                .forEach(employee -> System.out.println(employee.getDepartment() + " " + employee.getSalary() + " " + employee.getName()));

        // map -> one input and one output always
        // MOST IMPORTANT
        employees
                .forEach((emp) -> {
                    emp.setSalary(emp.getSalary() + 5000);
                    System.out.println(emp.getName() + " " + emp.getSalary());
                });


        // count how many it employees are there
        int count = Math.toIntExact(employees
                .stream()
                .filter(e -> e.getDepartment().equals("IT"))
                .count());
        System.out.println(count);

        // sort by salaries small to big
        List<Employee> se = employees
                .stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .toList();

        System.out.println(se);

        // get distinct cities
        List<String> se1 = employees
                .stream()
                .map(Employee::getCity)
                .distinct()
                .toList();

        System.out.println(se1);


        // INTERMEDIATE
        // group employees by departments
        Map<String, List<Employee>> result =  employees
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        System.out.println(result);

        // grouping employees by dept and counting
        Map<String, Long> result1 = employees
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

        System.out.println(result1);

        // group + average sal by department
        Map<String, Double> res2 =  employees
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

        System.out.println(res2);


        // Multi-level grouping (department → designation):
        Map<String, Map<String, List<Employee>>> byDeptThenDesignation = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.groupingBy(Employee::getDesignation)));


        // partitioningBy()
        // groupingBy can make as many baskets as needed (red, blue, green...). partitioningBy only ever makes exactly 2 baskets: "Yes" and "No."
        Map<Boolean, List<Employee>> managersVsOthers = employees.stream()
                .collect(Collectors.partitioningBy(Employee::isManager));

        // Collectors.joining()
        String allNames = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(", ", "[", "]"));


        // summaryStatistics() — get min/max/avg/sum/count in one shot
        DoubleSummaryStatistics stats = employees.stream().mapToDouble(Employee::getSalary).summaryStatistics();
        System.out.println(stats.getMax() + " " + stats.getMin() + " " + stats.getAverage() + " " + stats.getCount() + " " + stats.getSum());

        // reduce()
        // employee total salary using reduce
        double totalSalary = employees
                .stream()
                .map(Employee::getSalary)
                .reduce(0.0, Double::sum);

        // Employee with highest salary using reduce
        Optional<Employee> topEarner = employees.stream()
                .reduce((e1, e2) -> e1.getSalary() > e2.getSalary() ? e1 : e2);


        // flatMap() Get all unique skills across all employees
        List<String> allUniqueSkills = employees
                .stream()
                .flatMap(e -> e.getSkills().stream())
                .distinct()
                .toList();

        // Optional
        Optional<Employee> topEarner1 = employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary));

        topEarner1.ifPresent(e -> System.out.println(e.getName()));
        System.out.println(topEarner1.map(Employee::getName).orElse("No Employee"));


        // limit() and skip()
        // Top 3 highest paid employees
        List<Employee> top3 = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .limit(3)
                .toList();


        // Pagination: skip first 2, then take next 2
        List<Employee> page2 = employees.stream()
                .skip(2)
                .limit(2)
                .toList();


        // anyMatch(), allMatch(), noneMatch()
        boolean anyManager = employees.stream().anyMatch(Employee::isManager);        // true
        boolean allHighEarners = employees.stream().allMatch(e -> e.getSalary() > 30000); // true
        boolean noneInDelhi = employees.stream().noneMatch(e -> e.getCity().equals("Delhi")); // true

        // findFirst() and findAny()
        Optional<Employee> first = employees.stream()
                .filter(e -> e.getDepartment().equals("IT"))
                .findFirst();

        Optional<Employee> any = employees.parallelStream()
                .filter(e -> e.getDepartment().equals("IT"))
                .findAny();

        // Stream.iterate() vs Stream.generate() — infinite streams
        // iterate each element depends on the previous
        Stream.iterate(1, n -> n * 2).limit(5).forEach(n -> System.out.println(n));
        // generate() no relation between elements
        System.out.println(Stream.generate(() -> "Hello").limit(3));


        // PART 4 — CLASSIC INTERVIEW CODING QUESTIONS (Employee-based)
        // 1. find the second highest paid employee
        Optional<Employee> secondHighest = Optional.of(employees
                .stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .skip(1)
                .findFirst()
                .get());




    }
}
