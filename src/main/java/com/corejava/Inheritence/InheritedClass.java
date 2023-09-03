package com.corejava.Inheritence;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InheritedClass extends Inheritance {

    int seats = 100;

    public InheritedClass(int seats) {
        super(seats);
        log.info("inheritedClass constructor called");
    }

    String getSeats() {
        return "1000";
    }

}
