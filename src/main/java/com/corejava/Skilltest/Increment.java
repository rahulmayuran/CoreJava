package com.corejava.Skilltest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Increment {


    static void increment(int index) {
        ++index;
    }

    public static void main(String[] args) {

        int i = 0;
        increment(i);
        ++i;
        log.info(String.valueOf(i));

    }

}
