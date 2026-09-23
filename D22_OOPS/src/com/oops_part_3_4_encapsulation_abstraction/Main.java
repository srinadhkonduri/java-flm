package com.oops_part_3_4_encapsulation_abstraction;

public class Main {
    public static void main(String[] tony) {
        Company company = new Company();

        // Create employees of different types
        Manager manager = new Manager("Ravi", 101, 60000, 5);
        Developer developer = new Developer("Priya", 102, 50000, 8);
        Intern intern = new Intern("Anjali", 103, 15000);


        // Add them to the company
        company.addEmployee(manager);
        company.addEmployee(developer);
        company.addEmployee(intern);

        System.out.println("\n--- All Employee Details ---");
        company.showAllEmployees();

        System.out.println("\n all employees salaries");
        System.out.println(manager.getBaseSalary());
        System.out.println(developer.getBaseSalary());
        System.out.println(intern.getBaseSalary());

        System.out.println("\n--- Total Payroll ---");
        System.out.println("Total company payroll: " + company.calculateTotalPayRoll());

        System.out.println("\n--- Trying an INVALID setting ---");
        manager.setTeamSize(-5);   // should be rejected
        developer.setProjectsCompleted(-3);   // should be rejected
    }
}
