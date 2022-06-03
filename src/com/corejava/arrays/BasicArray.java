package com.corejava.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import static com.BaseLogger.Logger.commmonLogger;

public class BasicArray {

    private BasicArray() {
        commmonLogger.info("From Private constructor");
    }

    public static void main(String[] args) {

        char[] x = {'I', 'i', 'a', 'm'};
        commmonLogger.log(Level.INFO, ()-> "Concatenating char arrays of " + x[0] + "'" + x[3]);

        float[] floatArray = new float[3];
        floatArray[0] = 10.0f;
        floatArray[1] = 15.0f;
        floatArray[2] = 20.0f;

        List<Float> floatList = new ArrayList<>();
        floatList.add(2.3f);
        floatList.add(3.3f);

        float sumOfArray = 0.0f;
        float sumOfList = 0.0f;
        for (float v : floatArray) {
            sumOfArray += v;
        }
        for (float v : floatList) {
            sumOfList += v;
        }
        commmonLogger.info("The sum of float array is " + sumOfArray + ", " + sumOfList);
    }
}
