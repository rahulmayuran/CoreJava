package com.DSalgo.Company;

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

        EmployeeHelper helper = new EmployeeHelper();

        //Sort with salary in descending order
        helper.getEmployees().sort(Comparator.comparingInt(EmployeeHelper::getSalary).reversed());

        System.out.println("Salaries in reverse order -> " + helper.getEmployees());

        //Sort with Age in normal order
        helper.getEmployees().sort(Comparator.comparing(EmployeeHelper::getAge));

        //Now, Replace the ascending order names in the place of ascending age
        List<String> sortedNames = helper.getEmployees().stream()
                .sorted(Comparator.comparing(EmployeeHelper::getName))
                .map(EmployeeHelper::getName)
                .collect(Collectors.toList());

        System.out.println("sortedNames = " + sortedNames);

        int i=0;
        for(EmployeeHelper e : helper.getEmployees()){
            e.setName(sortedNames.get(i));
            i++;
        }
        System.out.println("End result after replacing names -> " + helper.getEmployees());

        /**
         * What is the purpose of Optional final class
         */
        System.out.println("Optional check ->" + optionalEmployee(Optional.of(new EmployeeHelper(11, "Some", 24, 242345))));
        System.out.println("Optional check empty object ->" + optionalEmployee(Optional.of(new EmployeeHelper())));
        System.out.println("Optional check null ->" + optionalEmployee(Optional.empty()));


    }

    public static Optional<EmployeeHelper> optionalEmployee(Optional<EmployeeHelper> o) {
        System.out.println();
        if(o.isPresent()){
            System.out.println("Employee object detected");
        } else {
            System.out.println("No Employee object found");
        }
        return o;
    }
}
