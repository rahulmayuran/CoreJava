package com.corejava.Skilltest;

import static com.BaseLogger.Logger.commmonLogger;

public class Increment {


    static void increment(int index) {
        ++index;
    }

    public static void main(String[] args) {

        int i = 0;
        increment(i);
        ++i;
        commmonLogger.info(String.valueOf(i));

    }

}
