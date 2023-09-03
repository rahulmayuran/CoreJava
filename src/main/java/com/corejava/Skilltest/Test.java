package com.corejava.Skilltest;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import lombok.var;

import java.util.function.Function;

@Slf4j
public class Test {
    public static void main(String[] args) {

        //val is a final value, can't be mutated.
        val f1 = (Function<String, String>) String::toUpperCase;
        var f2 = (Function<String, String>) String::toLowerCase;
        val f3 = (Function<String, String>) String::trim;
        var f4 = f1.andThen(f2).andThen(f3);


        log.info("Calling the Function expression " + f4.apply(" Hello World"));
    }
}
