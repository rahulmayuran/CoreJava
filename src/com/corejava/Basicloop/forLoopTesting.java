package com.corejava.Basicloop;

public class forLoopTesting {

    public static void main(String[] args) {

        int i = 1;

        for (i = 1; i < 5; i++) {
            System.out.println("i is " + i);
        }
        int j;
        for (j = 2; j < 100; j *= 2) {
            System.out.println(" j is " + j);
        }
        System.out.println("Static method call " + squareMethod(5));
        System.out.println("Inside main method + i->" + i + " and j ->" + j);
    }

    public static int squareMethod(int a) {
        int c = a;
        c = c * c;
        a = c;

        return a;
    }
}
