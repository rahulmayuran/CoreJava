package com.corejava.Basicloop;

import static com.BaseLogger.Logger.commmonLogger;

public class forLoopTesting {

    public static void main(String[] args) {

        int i = 1;

        for (i = 1; i < 5; i++) {
            commmonLogger.info("i is " + i);
        }
        int j;
        for (j = 2; j < 100; j *= 2) {
            commmonLogger.info(" j is " + j);
        }
        commmonLogger.info("Static method call " + squareMethod(5));
        commmonLogger.info("Inside main method + i->" + i + " and j ->" + j);
    }

    public static double squareMethod(int a) {
        return Math.pow(a, 2d);
    }
}
