package com.oops_part_3_4_encapsulation_abstraction;

import java.util.ArrayList;
import java.util.List;

public class Company {

    List<Employee> employees;

    public Company(){
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        employees.add(employee);
        System.out.println(employee.getEmployeeName() + " is added to the list");
    }

    public void showAllEmployees(){
        for (Employee employee : employees){
            employee.showDetails();
            System.out.println("---------------------------------");
        }
    }

    public double calculateTotalPayRoll(){
        double total = 0;
        for (Employee employee : employees){
            total += employee.calculateSalary();
        }
        return total;
    }

}
