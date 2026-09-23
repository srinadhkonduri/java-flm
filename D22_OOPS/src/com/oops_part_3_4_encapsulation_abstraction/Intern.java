package com.oops_part_3_4_encapsulation_abstraction;

public class Intern extends Employee{

    public Intern(String employeeName, int employeeId, double baseSalary) {
        super(employeeName, employeeId, baseSalary);
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + 500;
    }


}
