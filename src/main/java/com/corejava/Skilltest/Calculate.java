package com.corejava.Skilltest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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

            log.info(result + "<- result ");
        } catch (ArithmeticException e) {
            log.info("Caught ArithmeticException");
        } catch (IllegalArgumentException e) {
            log.info("Caught IllegalArgumentException");
        }

    }

    public static int divide(int x, int y) {

        try {
            return x / y;
        } catch (ArithmeticException e) {
            log.info("Div by zero");
            throw new IllegalArgumentException();
        } finally {
            log.info("Finally");
        }
    }
}

