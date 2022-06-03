package com.corejava.arrays;

import static com.BaseLogger.Logger.commmonLogger;

public class BasicArray {

    private BasicArray() {
        commmonLogger.info("From Private constructor");
    }

    public static void main(String[] args) {

        char[] x = {'I', 'i', 'a', 'm'};
        commmonLogger.info("Concatenating char arrays of " + x[0] + "'" + x[3]);

        float[] a = new float[3];
        a[0] = 10.0f;
        a[1] = 15.0f;
        a[2] = 20.0f;

        float sumOfA = 0.0f;
        for (float v : a) {
            sumOfA += v;
        }
        commmonLogger.info("The sum of float array is " + sumOfA);
    }
}
