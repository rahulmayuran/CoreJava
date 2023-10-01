package com.DSalgo.Company;

import com.DSalgo.error.CustomException;

import java.util.*;

public class Altimetrik {

    public static void main(String[] args) {

        //Round 1 - Problem Cleared
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

        //Round 2 - Problem 1
        System.out.println("Non repeating character = " + printNonRepeatingChar("Rahul raja"));;


        //Round 2 - Problem 2
        List<String> names = Arrays.asList("Autumn", "Spring", "Winter", "Summer", "Autumn");
        Set<String> dupeSet = new HashSet<>();

        //First approach using Collections
        Optional<String> dupe = names.stream()
                .filter(s -> Collections.frequency(names, s) > 1)
                .findFirst();

        //Second Approach using Filter
        Optional<String> dupeStr = names.stream()
                .filter(s -> !dupeSet.add(s))
                .findFirst();

        System.out.println("dupe => " + (dupe.isPresent() ? dupe.get() : new CustomException()));
        System.out.println("dupe with a set => " + (dupeStr.isPresent() ? dupeStr.get() : new CustomException()));
    }

    //"Rahul raja" => h is the non-dupe
    public static char printNonRepeatingChar(String s){
        //Initialize an integer array to hold all ASCII characters
       int[] intArr = new int[256];

       //Convert the given string to lowercase, and then transform it to a character array.
       char[] xhArr = s.toLowerCase().toCharArray();

       //Loop all the elements in the character array to validate the occurrences of each character
       for(char x : xhArr){
           intArr[x]++;
       }

       //Loop again with the character array to find out the element whose occurrence is 1.
        //Immediately return it!
       for(char c : xhArr){
           if(intArr[c] == 1){
               return c;
           }
       }
       return '\0';
    }
}
