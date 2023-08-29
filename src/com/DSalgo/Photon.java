package com.DSalgo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Photon {

    /**
     * Create 3 employee objects, With 4 parameters id, name, age and salary
     * Your goal is to compare them with salary in reverse order
     * age in ascending order
     * name in ascending order
     * @param args
     */
    public static void main(String[] args) {

        Employee e1 = new Employee(1, "Rahul", 23, 80000);
        Employee e2 = new Employee(2, "Bala", 24, 75000);
        Employee e3 = new Employee(3, "Dheeraj", 25, 90000);

        List<Employee> employees = Arrays.asList(e1, e2, e3);

        //Sort with salary in descending order
        employees.sort(Comparator.comparingInt(Employee::getSalary).reversed());

        System.out.println("Salaries in reverse order -> " + employees);

        //Sort with Age in normal order
        employees.sort(Comparator.comparing(Employee::getAge));

        //Now, Replace the ascending order names in the place of ascending age
        List<String> sortedNames = employees.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .map(Employee::getName)
                .collect(Collectors.toList());

        System.out.println("sortedNames = " + sortedNames);

        int i=0;
        for(Employee e : employees){
            e.setName(sortedNames.get(i));
            i++;
        }

        System.out.println("End result -> " + employees);

    }

    public Optional<Employee> getEmpl() {
        Optional<Employee> o = Optional.of(new Employee());
        if (o.isPresent()) {
            return o;
        }
        return Optional.of(new Employee());
    }
}


class Employee{
    private int id;
    private String name;
    private int age;
    private int salary;

    public int getId() {
        return id;
    }

    public Employee(){

    }
    public Employee(int id, String name, int age, int salary){
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
