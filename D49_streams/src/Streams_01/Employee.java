package Streams_01;

import java.time.LocalDate;
import java.util.List;

public class Employee {
    private int id;
    private String name;
    private String department;      // good for groupingBy
    private String designation;     // good for groupingBy (multi-level)
    private double salary;          // good for sum/avg/max/min, statistics
    private int age;                // good for filtering, partitioning
    private String gender;          // good for partitioningBy
    private String city;            // good for grouping/distinct
    private List<String> skills;    // good for flatMap
    private LocalDate joiningDate;  // good for sorting by date, filtering by year
    private boolean isManager;      // good for partitioningBy
    private double performanceRating; // good for sorting, comparators
    private String projectName;     // good for grouping/counting

    // Constructors
    public Employee() {}

    public Employee(int id, String name, String department, String designation,
                    double salary, int age, String gender, String city,
                    List<String> skills, LocalDate joiningDate,
                    boolean isManager, double performanceRating, String projectName) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.designation = designation;
        this.salary = salary;
        this.age = age;
        this.gender = gender;
        this.city = city;
        this.skills = skills;
        this.joiningDate = joiningDate;
        this.isManager = isManager;
        this.performanceRating = performanceRating;
        this.projectName = projectName;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public List<String> getSkills() { return skills; }
    public void setSkills(List<String> skills) { this.skills = skills; }

    public LocalDate getJoiningDate() { return joiningDate; }
    public void setJoiningDate(LocalDate joiningDate) { this.joiningDate = joiningDate; }

    public boolean isManager() { return isManager; }
    public void setManager(boolean manager) { isManager = manager; }

    public double getPerformanceRating() { return performanceRating; }
    public void setPerformanceRating(double performanceRating) { this.performanceRating = performanceRating; }

    public String getProjectName() { return projectName; }
    public void setProjectName(String projectName) { this.projectName = projectName; }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", designation='" + designation + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", city='" + city + '\'' +
                ", skills=" + skills +
                ", joiningDate=" + joiningDate +
                ", isManager=" + isManager +
                ", performanceRating=" + performanceRating +
                ", projectName='" + projectName + '\'' +
                '}';
    }
}