package com.corejava.arrays;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class SwitchStatements {

    public static void main(String[] args) throws Exception {

        log.info("Enter any integer Value :");
        Scanner a = new Scanner(System.in);
        int i = a.nextInt();

        switch (i % 2) {
            case 0:
                log.info(i + " Is even");
                break;
            case 1:
                log.info(i + " Is odd");
                break;
            default:
                log.info("Oops it broke");
                break;
        }
        a.close();
    }


}
