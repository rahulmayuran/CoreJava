package com.corejava.Skilltest;

public class ArmStrongNumber {

    public static void main(String[] args) {
        int c = 0, a, temp;
        int n = 153;//It is the number to check armstrong
        temp = n;
        while (n > 0) {
            a = n % 10;
            System.out.println(a); // 3 , 5 , 1
            n = n / 10;
            System.out.println(n); // 15 , 1 , 0
            c = c + (a * a * a);
            System.out.println(c); // 27 , 152(27 + 125) , 153 (27+125+1)
        }
        if (temp == c)
            System.out.println("armstrong number");
        else
            System.out.println("Not armstrong number");
    }
}
