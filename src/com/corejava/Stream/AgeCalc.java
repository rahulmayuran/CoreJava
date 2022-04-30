package com.corejava.Stream;

import java.time.LocalDate;
import java.time.Period;

public class AgeCalc {
    private LocalDate birthDate;
    private String name;

    public boolean isAdult(LocalDate when) {
        LocalDate now = LocalDate.now();
        Period age = Period.between(birthDate, now);
        Period adult = Period.ofYears(18);
        return (age.getYears() >= adult.getYears());
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    //create and add persons List code omitted//
	   /* List<String> personsNamesList = new ArrayListProblem<>();
	    for (AgeCalc person : persons) {
	        if (person.isAdult(LocalDate.now())) {
	            personsNamesList.add(person.getName());
	        }
	    }*/


    //Refracted using lambda expressions
    /*
     * List<String> personsNamesList = persons.stream() .filter(p ->
     * p.isAdult(LocalDate.now())) .map(p -> p.getName())
     * .collect(Collectors.toList());
     */
}




