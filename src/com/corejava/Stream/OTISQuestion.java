package com.corejava.Stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 Filter the employees in a particular departments{IT, Admin} with the highest salaries


 1 ravi IT 25000
 2 Satish IT 35000
 3. Kiran IT 40000

 4. Priya Admin 50000
 5. Mani Admin 45000

 */
public class OTISQuestion {
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "ravi", "IT", 25000));
        employees.add(new Employee(2, "Satish", "IT", 35000));
        employees.add(new Employee(3, "Kiran", "IT", 40000));
        employees.add(new Employee(4, "Priya", "Admin", 50000));
        employees.add(new Employee(5, "Mani", "Admin", 45000));

        List<Employee> result = new ArrayList<>(employees.stream()
                .collect(Collectors.toMap(Employee::getDepartment, Function.identity(),
                        BinaryOperator.maxBy(Comparator.comparingInt(Employee::getSalary))))
                .values());

        System.out.println("result List of Highest salary = " + result);

    }
}

class Employee {
    private int id;
    private String name;
    private String department;
    private int salary;

    public Employee(int id, String name, String department, int salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}
