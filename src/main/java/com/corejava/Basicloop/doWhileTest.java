package com.corejava.Basicloop;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class doWhileTest {

    //do while also executes the statements in a loop until the condition is satisfied
    //But the condition is checked at last and stops by a final check
    //priority -> Do statements then condition

    public static void main(String[] args) {
        int i = 8;
        int doWhileCounter = 0;
        do {
            log.info("i val -> " + i);
            i = i * 4;
            doWhileCounter += 1;
            log.info("  * 4 = " + i +"\n");
        }
        while (i < 2049);
        log.info("Exited do while as "+ i + " exceeded 1000 when looped times reach " + doWhileCounter + "\n\n");

        // For While Loop with same conditions
        int j = 8;
        int whileCounter = 0;
        while( j < 2049){
            log.info("j val is -> " + j);
            j = j * 4;
            whileCounter += 1;
            log.info("  * 4 = " + j +"\n");
        }
        log.info("Exited while as "+ j + " exceeded 1000 when looped times reach " + whileCounter);


    }

}
