package com.corejava.HackerRank;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

/*If the number is negative, throw an exception , If it is zero, throw an exception
If they are proper, then print the power of i to n.
* */
@Slf4j
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
            log.info(String.valueOf(Math.pow(first,second)));
        }
    }
}
