package com.corejava.Basicloop;

import static com.BaseLogger.Logger.commmonLogger;

public class whileFactorial {

    /*
     * while loop repeatedly executes the statements unless the condition is
     * satisfied. It checks the condition at the end of the loop
     */

    public static void main(String[] args) {
        int num = 6;
        int factorial = 1;
        while (num > 1) {
            factorial *= num; // factorial = factorial*num , becomes 6
            num -= 1; // 6= 6-1, becomes 5
            //again while loop starts because num is still not less than 1,

        }
        commmonLogger.info("Value of 6 factorial is " + factorial);
    }
}
	
