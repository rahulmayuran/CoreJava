package com.corejava.Basicloop;

import static com.BaseLogger.Logger.commmonLogger;

public class doWhileTest {

    //do while also executes the statements in a loop until the condition is satisfied
    //But the condition is checked at last and stops by a final check
    //priority -> Do statements then condition

    public static void main(String[] args) {
        int i = 8;
        do {
            commmonLogger.info(String.valueOf(i));
            commmonLogger.info("  * 4 =");
            commmonLogger.info(String.valueOf(i = i * 4));


        }
        while (i < 1000);
        commmonLogger.info("Exited while");

    }

}
