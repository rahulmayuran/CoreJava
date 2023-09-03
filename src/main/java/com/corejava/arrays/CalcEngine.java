package com.corejava.arrays;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CalcEngine {

//use arrays, for loop, for Each loop, switch statements all at once
// To perform basic arithmetic operations

    public static void main(String[] args) {

        double[] left = {100.0d, 200.0d, 300.0d, 400.0d};
        double[] right = {50.0d, 100.0d, 150.0d, 200.0d};
        char[] opcodes = {'a', 's', 'm', 'd'};
        double[] results = new double[opcodes.length]; // This will allocate 4 spaces of values
        //with indexes 0 to 3 and stores it in results array.

        for (int i = 0; i < opcodes.length; i++) {
            switch (opcodes[i]) {
                case 'a':
                    results[i] = left[i] + right[i];
                    break;
                case 's':
                    results[i] = left[i] - right[i];
                    break;
                case 'm':
                    results[i] = left[i] * right[i];
                    break;
                case 'd':
                    results[i] = left[i] / right[i];
                    break;
                default:
                    log.info("Invalid Opcode");
                    break;
            }
        }
        for (double resultsFor : results) {
            log.info("result : " + resultsFor + " Map -> ");
        }
    }
}
		
	

