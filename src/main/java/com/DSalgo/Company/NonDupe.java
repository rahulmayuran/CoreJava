package com.DSalgo.Company;

import java.util.*;

public class NonDupe {

    public static void main(String[] args) {

        System.out.println(findNonDupe("REARED"));
        System.out.println(findNonDupe2("REARED"));
//        System.out.println(findNonDupe3("CORONA"));

    }

    public static char findNonDupe(String str){

        HashMap<Character, Integer> charCount = new HashMap<>();

        for(char c : str.toCharArray()){

//            This can also be used
//            charCount.put(c, charCount.getOrDefault(c, 1) + 1);

            if(charCount.containsKey(c)){
                charCount.put(c, charCount.get(c) + 1);
            } else {
                charCount.put(c, 1);
            }
        }

        for(char c : str.toCharArray()){
            if(charCount.get(c) == 1){
                return c;
            }
        }
        return '\0';
    }

    public static char findNonDupe2(String str){

        //Array to store character counts
        int[] charr = new int[256];

        //Load the character array with the given string, to update the frequencies.
        for(char c : str.toCharArray()){
            charr[c]++;
        }

        //When the frequency is 1, then print it
        for(char c : str.toCharArray()){
            if(charr[c] == 1){
                return c;
            }
        }
        return '\0';
    }

    /*public static char findNonDupe3(String str){
        List<char[]> chList = List.of(str.toCharArray());
        Optional<char[]> res = chList.stream()
                .filter(e -> Collections.frequency(chList, e) == 1)
                .findFirst();

        return res.map(chars -> chars[0]).orElse('\0');
    }*/

}
