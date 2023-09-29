package com.DSalgo.Company;

import com.DSalgo.error.CustomException;

import java.util.*;

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

        System.out.println("Non repeating character = " + printNonRepeatingChar("Rahul raja"));;


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

    //"Rahul raja" => h
    public static char printNonRepeatingChar(String s){
       int[] intArr = new int[256];
       char[] xhArr = s.toLowerCase().toCharArray();
       for(char x : xhArr){
           intArr[x]++;
       }
       for(char c : xhArr){
           if(intArr[c] == 1){
               return c;
           }
       }
       return '\0';
    }
}
