package com.corejava.HackerRank;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;


/*
*
* Using Pattern.compile method, check whether the provided regex pattern is valid or not.
* It should search for the patterns and should check whether it is valid or not.
* */
@Slf4j
public class PatternSyntaxChecker {

    public static void main(String[] args) {

        log.info("Enter the Regex pattern that you know ->");
        Scanner input = new Scanner(System.in);

        String pattern = input.nextLine();

        try {
            Pattern.compile(pattern);
            log.info("VALID");
        } catch (PatternSyntaxException e) {
            log.info("INVALID");
        }
    }
}
