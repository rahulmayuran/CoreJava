package com.time_space_complexity;

import com.BaseLogger.LogHelper;

public class Basic {

    /**
     * Recursive call for summation
     * Time -> O(N)
     * Space -> O(N)
     */
    private int sum(int n) {
        if (n <= 0) {
            return 0;
        }
        return n + sum(n - 1);
    }

    public static void main(String[] args) {
        Basic basicExamples = new Basic();
//        LogHelper.logger(basicExamples.sum(4));
    }
}
