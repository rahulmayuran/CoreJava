package com.corejava.arrays;

import java.util.Scanner;

import static com.BaseLogger.Logger.commmonLogger;

public class SwitchStatements {

    public static void main(String[] args) throws Exception {

        commmonLogger.info("Enter any integer Value :");
        Scanner a = new Scanner(System.in);
        int i = a.nextInt();

        switch (i % 2) {
            case 0:
                commmonLogger.info(i + " Is even");
                break;
            case 1:
                commmonLogger.info(i + " Is odd");
                break;
            default:
                commmonLogger.info("Oops it broke");
                break;
        }
        a.close();
    }


}
