package com.oops_part_3_4_encapsulation_abstraction;

public class Manager extends Employee {

    private int teamSize;

    public Manager(String employeeName, int employeeId, double baseSalary, int teamSize) {
        super(employeeName, employeeId, baseSalary);
        setTeamSize(teamSize);
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        if (teamSize < 0){
            System.out.println("team size must be > 0");
        }
        this.teamSize = teamSize;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + (teamSize * 1000);
    }
}
