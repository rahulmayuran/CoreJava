package com.DSalgo.Company;

import java.util.Arrays;
import java.util.List;

public class EmployeeHelper {
    private int id;
    private String name;
    private int age;
    private int salary;

    public int getId() {
        return id;
    }

    public EmployeeHelper(){

    }
    public EmployeeHelper(int id, String name, int age, int salary){
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public List<EmployeeHelper> getEmployees(){
        EmployeeHelper e1 = new EmployeeHelper(1, "Rahul", 23, 80000);
        EmployeeHelper e2 = new EmployeeHelper(2, "Bala", 24, 75000);
        EmployeeHelper e3 = new EmployeeHelper(3, "Dheeraj", 25, 90000);

        return Arrays.asList(e1, e2, e3);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
