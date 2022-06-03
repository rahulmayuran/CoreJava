package com.corejava.complexTypes;

import static com.BaseLogger.Logger.commmonLogger;

public class ReturnTypes {

    public static void main(String[] args) {

        ReturnTypes sum = new ReturnTypes();
        commmonLogger.info(sum.sumOf());
    }

    private String sumOf() {
        int total = 18;
        int x = 12;
        int y = 15;
        return "total < x + y";
    }

}
