package com.corejava.Skilltest;

public class Increment {


    static void increment(int index) {
        ++index;
    }

    public static void main(String[] args) {

        int i = 0;
        increment(i);
        ++i;
        System.out.println(i);

    }

}
