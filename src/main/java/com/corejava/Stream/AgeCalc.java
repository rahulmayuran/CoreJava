package com.corejava.Stream;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.time.Period;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Getter
@Setter
@ToString
public class AgeCalc {

    private String name;

    public static boolean isAdult(int age) {
        Period adult = Period.ofYears(18);
        return age >= adult.getYears();
    }

    public static void main(String[] args) {


        List<Person> persons = Arrays.asList(new Person("Gullu", 11),
                new Person("Saif", 23),
                new Person("Malik", 21));

        //Refracted using lambda expressions
        List<String> names = persons.stream()
                .filter(p -> isAdult(p.getAge()))
                .map(Person::getName)
                .collect(Collectors.toList());

        log.info("Adults: " + names);
    }
}




