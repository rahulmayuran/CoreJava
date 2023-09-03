package com.corejava.Skilltest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ArmStrongNumber {

    public static void main(String[] args) {
        int c = 0, a, temp;
        int n = 153;//It is the number to check armstrong
        temp = n;
        while (n > 0) {
            a = n % 10;
            log.info(String.valueOf(a)); // 3 , 5 , 1
            n = n / 10;
            log.info(String.valueOf(n)); // 15 , 1 , 0
            c = c + (a * a * a);
            log.info(String.valueOf(c)); // 27 , 152(27 + 125) , 153 (27+125+1)
        }
        if (temp == c)
            log.info("armstrong number");
        else
            log.info("Not armstrong number");
    }
}
