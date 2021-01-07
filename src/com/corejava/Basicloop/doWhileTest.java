package com.corejava.Basicloop;

public class doWhileTest {

    //do while also executes the statements in a loop until the condition is satisfied
    //But the condition is checked at last and stops by a final check
    //priority -> Do statements then condition

    public static void main(String[] args) {
        int i = 8;
        do {
            System.out.print(i);
            System.out.print("  * 4 =");
            System.out.println(i = i * 4);


        }
        while (i < 1000);
        System.out.println("Exited while");

    }

}
