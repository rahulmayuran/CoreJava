package com.corejava.Skilltest;

import java.util.function.Function;

import static com.BaseLogger.Logger.commmonLogger;

public class Test {
    public static void main(String[] args) {
        Function<String, String> f1 = String::toUpperCase;
        Function<String, String> f2 = String::toLowerCase;
        Function<String, String> f3 = String::trim;
        Function<String, String> f4 = f1.andThen(f2).andThen(f3);


        commmonLogger.info(f4.apply(" Hello World"));
    }
}
