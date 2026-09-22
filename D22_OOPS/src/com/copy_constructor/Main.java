package com.copy_constructor;

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("tony","tony@gmail.com");
        Employee employee1 = new Employee(employee);

        System.out.println(employee1);
    }

}
