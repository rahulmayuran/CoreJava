package com.corejava.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Listplay {

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("Alpha", "Beta", "Gamma", "Delta", "Epsilon");

        //Prints Epsilon by comparing lengths of 5 strings using .reduce() method & prints longer string
        Optional<String> reduced = stringList.stream().reduce((s1, s2) -> s1.length() > s2.length() ? s1 : s2);

        //Prints Beta by comparing lengths of 5 strings using .reduce() method & prints shorter string
        //Optional<String> reduced = stringList.stream().reduce((s1, s2) -> s1.length() > s2.length() ? s1 : s2);


        System.out.println(reduced.get());

    }

}
