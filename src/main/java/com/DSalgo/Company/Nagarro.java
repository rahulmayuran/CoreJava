package com.DSalgo.Company;

import java.util.ArrayList;
import java.util.List;

public class Nagarro {

    public static void main(String[] args) {

        //Problem 1
        int[] input = {14, 14, 18, 18, 9, 23};
        int[] output = findDuplicatesInArray(input, input.length);

        //Problem 1 alternative
        for(int i : output){
            System.out.print(i +" ");
        }

        //Problem 2
        System.out.print(distanceBetweenMostRepeatedChars("I have A race car"));


    }

    private static int distanceBetweenMostRepeatedChars(String in) {
        
        char[] chArr = in.toLowerCase()
                .replace(" ", "")
                .toCharArray();

        int[] intArr = new int[256];

        //Update the frequencies of characters
        for(char c : chArr){
            intArr[c]++;
        }
        int max = 0;
        char res = 0;
        for(char c : chArr){
            if(intArr[c] > max){
                max = intArr[c];
                res = c;
            }
        }
        System.out.println("Most repeated character is : "+ res);
        String strippedString = in.toLowerCase()
                .replace(" ", "");
        System.out.println("Stripped string is " + strippedString);
        System.out.println("The distance between the first and last occurrence of " + res + " is ");

        int diff = (strippedString.lastIndexOf(res) - strippedString.indexOf(res));
        return diff <= 0 ? -1 : diff;

    }

    private static int[] findDuplicatesInArray(int[] input, int k){

        List<Integer> duplicates = new ArrayList<>();

        for (int i = 0, j = 1; i < k && j < k-1; i++, j++) {
            if(input[i] == input[j]){
                duplicates.add(input[i]);
            }
        }
        System.out.println("Duplicates are : " + duplicates);

        if(duplicates.isEmpty()){
            return new int[]{-1};
        }

        int[] res = new int[duplicates.size()];
        int count = 0;
        for(int i : duplicates){
            res[count] = i;
            count++;
        }
        return res;
    }
}
