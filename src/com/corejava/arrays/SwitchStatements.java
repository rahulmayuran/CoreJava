package com.corejava.arrays;

import java.util.Scanner;

public class SwitchStatements {

    public static void main(String[] args) throws Exception {

        System.out.print("Enter any integer Value :");
        Scanner a = new Scanner(System.in);
        int i = a.nextInt();

        switch (i % 2) {
            case 0:
                System.out.println(i + " Is even");
                break;
            case 1:
                System.out.println(i + " Is odd");
                break;
            default:
                System.out.println("Oops it broke");
                break;
        }
        a.close();
    }


}
