package com.corejava.HackerRank;

import java.util.Scanner;

import static com.BaseLogger.Logger.commmonLogger;

/*If the number is negative, throw an exception , If it is zero, throw an exception
If they are proper, then print the power of i to n.
* */
public class ExceptionHandling {

    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);
        int first = input.nextInt();
        int second = input.nextInt();

        if(first<0 || second<0){
            throw new Exception("NUMBERS ARE NEGATIVE");
        }
        else if(first == 0 && second==0)
        {
            throw new Exception("NUMBERS ARE ZERO");
        }
        else{
            commmonLogger.info(String.valueOf(Math.pow(first,second)));
        }
    }
}
