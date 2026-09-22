package com.oops_part_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);


        System.out.println("Enter how many employees you want to add : ");
        int count = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < count; i++) {
            System.out.println("\nEnter the " + (i + 1) + " employee details:");
            Employee employee = takingInputOfDetails();
            employees.add(employee);
        }

        System.out.println("\n All Employees");
        for (Employee employee : employees){
            System.out.println(employee);
        }

        scanner.close();

    }


    static Employee takingInputOfDetails(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of the employee :");
        String name = scanner.nextLine();

        System.out.println("Enter the age : ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the email : ");
        String email = scanner.nextLine();

        System.out.println("Enter the salary : ");
        double salary = scanner.nextDouble();

        return new Employee(name,age,email,salary);
    }
}
