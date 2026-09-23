package com.oops_part_3_4_encapsulation_abstraction;

public abstract class Employee {
    private String employeeName;
    private int employeeId;
    private double baseSalary;

    public Employee(String employeeName, int employeeId, double baseSalary) {
        this.employeeName = employeeName;
        this.employeeId = employeeId;
        setBaseSalary(baseSalary);   // validate even at creation time!
    }

    // ABSTRACT METHOD - every employee type must calculate salary their OWN way
    public abstract double calculateSalary();

    public void showDetails() {
        System.out.println("Name: " + employeeName);
        System.out.println("ID: " + employeeId);
        System.out.println("Base Salary: " + baseSalary);
        System.out.println("Final Salary: " + calculateSalary());
    }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary < 0) {
            System.out.println("Invalid! Salary cannot be negative");
            return;
        }
        this.baseSalary = baseSalary;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public int getEmployeeId() {
        return employeeId;
    }
}
