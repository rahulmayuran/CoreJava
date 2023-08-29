package com.DSalgo.Company;

public class Altimetrik {

    public static void main(String[] args) {

        for (int i = 1; i <= 7; i=i+2) {
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = 3; i <= 7; i=i+2) {
            for (int j = 7-i; j >= 0; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
