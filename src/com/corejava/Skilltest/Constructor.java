package com.corejava.Skilltest;

import static com.BaseLogger.Logger.commmonLogger;

public class Constructor {

    private Constructor() {
        commmonLogger.info("private constructor");
    }

    private static void Constructorcall() {
        // TODO Auto-generated method stub
    }

    public static void main(String[] args) {
        Constructorcall();
    }

}
