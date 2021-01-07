package com.corejava.Skilltest;

public class Calculate {

    /*
     *Why this output?
     *If you evaluate closely the first try block calls divide method of values 3 and 0,
     *Which is an arithmetic exception, so it jumps to another try block ,It catches
     *the exception first and Div by zero is printed, Then finally block is printed as
     *it is executed even if there are exceptions/ not.
     */
    public static void main(String[] args) {

        try {

            int result = divide(3, 0);

            System.out.println(result + "<- result ");
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException");
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException");
        }

    }

    public static int divide(int x, int y) {

        try {
            return x / y;
        } catch (ArithmeticException e) {
            System.out.println("Div by zero");
            throw new IllegalArgumentException();
        } finally {
            System.out.println("Finally");
        }
    }
}

