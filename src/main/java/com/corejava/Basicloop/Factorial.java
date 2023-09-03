package com.corejava.Basicloop;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Factorial {

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
        log.info("Value of 6 factorial is " + factorial);

        Factorial ins = new Factorial();
        log.info("Value of recursive factorial is " + ins.fact(5));
    }

    // Recursive Function of factorial
    private int fact(int a){
        if(a<0) {
            return 0;
        }else if(a==0){
            return 1;
        } else {
            return a * fact(a - 1);
        }
    }
}
	
