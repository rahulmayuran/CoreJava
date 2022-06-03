package com.corejava.Inheritence;

import static com.BaseLogger.Logger.commmonLogger;

public class InheritedClass extends Inheritance {

    int seats = 100;

    public InheritedClass(int seats) {
        super(seats);
        commmonLogger.info("inheritedClass constructer called");
    }

    String getSeats() {
        return "1000";
    }

}
