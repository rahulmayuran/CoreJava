package com.corejava.HackerRank;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/*
*
* Using Pattern.compile method, check whether the provided regex pattern is valid or not.
* It should search for the patterns and should check whether it is valid or not.
* */
public class PatternSyntaxChecker {

    public static void main(String[] args) {

        System.out.println("Enter the Regex pattern that you know ->");
        Scanner input = new Scanner(System.in);

        String pattern = input.nextLine();

        try {
            Pattern.compile(pattern);
            System.out.println("VALID");
        } catch (PatternSyntaxException e) {
            System.out.println("INVALID");
        }
    }
}
