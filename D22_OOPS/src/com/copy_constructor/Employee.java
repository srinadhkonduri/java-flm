package com.copy_constructor;

public class Employee {
    String name;
    String email;


    // normal constructor
    public Employee(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // copy constructor --> creates a new OBJECT using the existing object
    public Employee(Employee employee){
        this.name = employee.name;
        this.email = employee.email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
