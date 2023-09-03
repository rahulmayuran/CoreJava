package com.corejava.complexTypes;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReturnTypes {

    public static void main(String[] args) {

        ReturnTypes sum = new ReturnTypes();
        log.info(sum.sumOf());
    }

    private String sumOf() {
        int total = 18;
        int x = 12;
        int y = 15;
        return "total < x + y";
    }

}
