package com.corejava.Basicloop;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class forLoopTesting {

    public static void main(String[] args) {

        int i = 1;

        for (i = 1; i < 5; i++) {
            log.info("i is " + i);
        }
        int j;
        for (j = 2; j < 100; j *= 2) {
            log.info(" j is " + j);
        }
        log.info("Static method call " + squareMethod(5));
        log.info("Inside main method + i->" + i + " and j ->" + j);
    }

    public static double squareMethod(int a) {
        return Math.pow(a, 2d);
    }
}
