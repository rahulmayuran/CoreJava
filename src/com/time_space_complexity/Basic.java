package com.time_space_complexity;

import static com.LogHelper.loghelper;

public class Basic{


    public static void main(String[] args)
    {
        Basic basicExamples = new Basic();
        loghelper.info("Summation of 4 by Recursive calls -> " + basicExamples.sum(4));
        loghelper.info("Summation of first 4 odd numbers -> " + basicExamples.sumOfOddNos(4));
        loghelper.info("Summation of first 4 even numbers -> " + basicExamples.sumOfEvenNos(4));
        loghelper.info("Recursion call for first 4 numbers -> " + basicExamples.recursionCall(4));
    }

    /**
     * Recursive call for summation for , Time -> O(N), Space -> O(N)
     */
    private int sum(int n) {
        if (n <= 0) {
            return 0;
        }
        return n + sum(n - 1);
    }

    /**
     * Add odd elements from 0 -> n , Time -> O(1), Space -> O(1)
     */
    protected int pairedSum(int a , int b){
        return a+b;
    }
    private int sumOfOddNos(int n){
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += pairedSum(i, i+1); //1+3+5+7
        }
        return sum;
    }

    /**
     * Add even elements from 0 -> n, Time -> O(1), Space -> O(1)
     */
    private int sumOfEvenNos(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += pairedSum(i, i+2); //2+4+6+8
        }
        return sum;
    }

    /**
     * Time -> O(2^n), Space -> O(N)
     * Explanation -> For every recursive call, the time complexity is calculated as
     * O(branches ^ depth) ie., here there are 2 branches with a depth of n.
     * @param n
     * @return 2^(n)
     */
    private int recursionCall(int n){
        if(n<=0){
            return 1;
        }
        return recursionCall(n-1) + recursionCall(n-1);
    }

}
