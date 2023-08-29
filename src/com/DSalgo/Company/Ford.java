package com.DSalgo.Company;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ford {

    public static void main(String[] args) {

        List<String> seasons = Arrays.asList("Summer", "Winter", "Spring", "Autumn");

        seasons.sort(Collections.reverseOrder());
        seasons.stream()
                .filter(i -> !i.equalsIgnoreCase("WInter"))
                .forEach(System.out::println);

        System.out.println(isPrime(13));
    }

    private static boolean isPrime(int n){
        for(int i=2; i*i<n ;i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }

}
