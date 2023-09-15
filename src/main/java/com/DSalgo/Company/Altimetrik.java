package com.DSalgo.Company;

import java.util.*;
import java.util.stream.Collectors;

public class Altimetrik {

    public static void main(String[] args) {

        for (int i = 1; i <= 7; i=i+2) {
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = 3; i <= 7; i=i+2) {
            for (int j = 7-i; j >= 0; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }

        printNonRepeatingChar("Rahul raja");


        List<String> names = Arrays.asList("Autumn", "Spring", "Winter", "Summer", "Autumn");
        Set<String> dupeSet = new HashSet<>();

        Optional<String> dupe = names.stream()
                .filter(s -> Collections.frequency(names, s) > 1)
                .findFirst();

        Optional<String> dupeStr = names.stream()
                .filter(s -> !dupeSet.add(s))
                .findFirst();

        System.out.println("dupe => " + (dupe.isPresent() ? dupe.get() : new CustomException()));
        System.out.println("dupe with a set => " + (dupeStr.isPresent() ? dupeStr.get() : new CustomException()));
    }

    //"Rahul raja"
    public static char printNonRepeatingChar(String s){
        char[] ch = s.toLowerCase().toCharArray();
        Map<Character, Integer> res = new HashMap<>();
        List<Character> out = new ArrayList<>();

        for (int i = 0; i < ch.length; i++) {
            if(!res.containsKey(ch[i])){
                System.out.println("Distinct Character -> " + ch[i]);
                out.add(ch[i]);
            }
            res.put(ch[i], i);
        }
        System.out.println("Non repeating chars " + out);
        return 'a';
    }
}
