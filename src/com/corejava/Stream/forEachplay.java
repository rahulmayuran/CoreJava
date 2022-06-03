package com.corejava.Stream;

import java.util.stream.Stream;

import static com.BaseLogger.Logger.commmonLogger;

public class forEachplay {

    /*
     * The output should be
     * forEach: B1
     * forEach: B2
     */

    public static void main(String[] args)
    {
        Stream.of("a1", "b1", "b2", "c1", "d1")
                .filter(s -> s.startsWith("b"))
                .sorted()
                .map(String::toUpperCase)
                .forEach(s -> commmonLogger.info("forEach: " + s));
    }

}
