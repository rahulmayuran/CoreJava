package com.corejava.Skilltest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Constructor {

    private Constructor() {
        log.info("private constructor");
    }

    private static void Constructorcall() {
        // TODO Auto-generated method stub
    }

    public static void main(String[] args) {
        Constructorcall();
    }

}
