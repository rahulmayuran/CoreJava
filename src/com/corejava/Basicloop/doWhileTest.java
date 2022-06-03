package com.corejava.Basicloop;

import static com.BaseLogger.Logger.commmonLogger;

public class doWhileTest {

    //do while also executes the statements in a loop until the condition is satisfied
    //But the condition is checked at last and stops by a final check
    //priority -> Do statements then condition

    public static void main(String[] args) {
        int i = 8;
        int doWhileCounter = 0;
        do {
            System.out.print(i);
            i = i * 4;
            doWhileCounter += 1;
            System.out.print("  * 4 = " + i +"\n");
        }
        while (i < 2049);
        System.out.println("Exited do while as "+ i + " exceeded 1000 when looped times reach " + doWhileCounter + "\n\n");

        // For While Loop with same conditions
        int j = 8;
        int whileCounter = 0;
        while( j < 2049){
            System.out.print(j);
            j = j * 4;
            whileCounter += 1;
            System.out.print("  * 4 = " + j +"\n");
        }
        System.out.println("Exited while as "+ j + " exceeded 1000 when looped times reach " + whileCounter);


    }

}
