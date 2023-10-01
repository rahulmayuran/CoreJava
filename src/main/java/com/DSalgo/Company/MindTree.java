package com.DSalgo.Company;

import com.DSalgo.error.CustomException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Printer {
    public Printer() {
        System.out.println("Printer:Constructor");
    }

    {
        System.out.println("Printer:A");
    }

    static {
        System.out.println("Printer:B");
    }

    public void m1() {
        System.out.println("m1-Printer");
    }

    public static void m2() {
        System.out.println("m2-Printer");
    }
}

class HpPrinter extends Printer {
    public HpPrinter() {
        System.out.println("HpPrinter:Constructor");
    }

    {
        System.out.println("HpPrinter:A");
    }

    static {
        System.out.println("HpPrinter:B");
    }

    public void m1() {
        System.out.println("m1-HpPrinter");
    }

    public static void m2() {
        System.out.println("m2-HpPrinter");
    }
}

public class MindTree {

    //Problem 1: Print the order of execution.

    /*
        Printer:B - static block of parent class
        HpPrinter:B - static block of inherited class
        Printer:A - non-static block of parent class
        Printer:Constructor - constructor of parent class
        HpPrinter:A - non-static block of inherited class
        HpPrinter:Constructor - constructor of inherited class
        m1-HpPrinter - inherited class's m1() method overrides the parent class's m1() method
        m2-Printer - parent class's m2() method overrides the inherited
     */

    //Problem-2 two sum problem - solved
    //Problem-3 Increase Employee's salary
    //Problem-4 Drill deep into Optional class in Java


    public static void main(String[] args)
            throws Exception {

        //Problem1
        Printer obj1 = new HpPrinter(); //op?
        obj1.m1(); //op?
        obj1.m2(); //op?

        //Problem2
        System.out.print("2: Two-sum problem indices summing up to the target :");
        Arrays.stream(twoSum(new int[]{2, 7, 6, 3, 5, 4}, 9))
                .forEach(e -> System.out.print(e + " "));

        System.out.println();

        //Problem3
        EmployeeHelper employee = new EmployeeHelper();

        List<EmployeeHelper> updatedSalaryList = employee.getEmployees()
                .stream()
                .filter(e -> e.getSalary() < 100000)
                .peek(e -> e.setSalary((int) (e.getSalary() * 1.1)))
                .collect(Collectors.toList());

        System.out.println("3: Updated salaries for the employees whose salary is less than 1 lakh " +
                "is increased by 10% -> " + updatedSalaryList);

        //Problem4

        //Three ways of initializing
        Optional<List<EmployeeHelper>> employeesOfNullable = Optional.ofNullable(updatedSalaryList);
        Optional<List<EmployeeHelper>> employeesOf = Optional.of(updatedSalaryList);
        Optional<List<EmployeeHelper>> employeesIsEmpty = Optional.empty();

        //Optional class's defaulted methods for an optional object
        if (employeesOfNullable.isPresent()) {
            System.out.println("4: Playing with Optional, isPresent() and get() -> " + employeesOfNullable.get());
        }
        employeesOfNullable.ifPresent(employeeHelpers -> System.out.println("Playing with Optional, ifPresent() -> " + employeeHelpers));

        System.out.println("Playing with Optional filter() -> " + employeesOfNullable.filter(List::isEmpty));
        System.out.println("Playing with Optional, hashCode() -> " + employeesOfNullable.hashCode());
//        System.out.println("Playing with Optional, or()" + employeesOfNullable.or(()-> Optional.of(employee.getEmployees())));

        List<String> names = employee.getEmployees().stream()
                .map(EmployeeHelper::getName)
                .collect(Collectors.toList());

        Stream<String> streamedNames = employee.getEmployees().stream()
                .map(EmployeeHelper::getName);

        System.out.println("Playing with Optional, map() inside a map() -> " + employeesOfNullable.map(e -> names));
        System.out.println("Playing with Optional, flatMap() -> " + employeesOfNullable.flatMap(e -> streamedNames.findFirst()));
        System.out.println("Playing with Optional, orElse() -> " + employeesOfNullable.orElse(employee.getEmployees()));
        System.out.println("Playing with Optional, orElseGet() ->" + employeesIsEmpty.orElseGet(ArrayList::new));
        System.out.println("Playing with Optional, orElseThrow() ->" + employeesIsEmpty.orElseThrow(() -> new CustomException("It is an Empty optional object")));
//        employeesIsEmpty.ifPresentOrElse( value -> System.out.println("Value is present, its: " + value),
//                () -> System.out.println("Value is empty"));
    }

    private static int[] twoSum(int[] input, int sum) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < input.length; i++) {
            if (map.containsKey(sum - input[i])) {
                res[0] = map.get(sum - input[i]);
                res[1] = i;
            }
            map.put(input[i], i);
        }
//        System.out.println("Filled map is "+ map);
//        for (Map.Entry<Integer, Integer> b : map.entrySet()){
//            System.out.println("Value is :" + b.getValue() + " for key :" + b.getKey());
//        }
        return res;
    }

}


