package com.corejava.arrays;

public class BasicArray {

    private BasicArray() {
        System.out.println("From Private constructor");
    }

    public static void main(String[] args) {

        char[] x = {'I', 'i', 'a', 'm'};
        System.out.println("Concatenating char arrays of " + x[0] + "'" + x[3]);

        //---------------------------------------------------------------

        float[] a = new float[3];
        a[0] = 10.0f;
        a[1] = 15.0f;
        a[2] = 20.0f;

        float sumOfA = 0.0f;
        for (float v : a) {
            sumOfA += v; // sumOfA = sumOfA + a[0] // 0.0 = 0.0 +10 = 10
            //10 = 10 +15 = 25 // 25 =25+20 = 45
        }
        System.out.println("The sum of float array is " + sumOfA);
        System.out.println(new BasicArray());

        //---------------------------------------------------------------

        float sumforEachofA = 0;
        for (float forEach : a) {
            sumforEachofA += forEach;
        }
        System.out.println("The sum of float array using forEach is " + sumforEachofA);
    }
}
