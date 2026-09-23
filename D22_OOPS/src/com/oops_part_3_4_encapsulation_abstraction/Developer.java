package com.oops_part_3_4_encapsulation_abstraction;

public class Developer extends Employee{

    private int projectsCompleted;

    public Developer(String employeeName, int employeeId, double baseSalary, int projectsCompleted) {
        super(employeeName, employeeId, baseSalary);
        setProjectsCompleted(projectsCompleted);
    }

    public int getProjectsCompleted() {
        return projectsCompleted;
    }

    public void setProjectsCompleted(int projectsCompleted) {
        if (projectsCompleted < 0){
            System.out.println("must be > 0");
            return;
        }
        this.projectsCompleted = projectsCompleted;
    }


    @Override
    public double calculateSalary() {
        return getBaseSalary() + (projectsCompleted * 2000);
    }
}
