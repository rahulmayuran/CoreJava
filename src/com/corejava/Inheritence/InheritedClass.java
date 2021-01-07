package com.corejava.Inheritence;

public class InheritedClass extends Inheritance {

    int seats = 100;

    public InheritedClass(int seats) {
        super(seats);
        System.out.println("inheritedClass constructer called");
    }

    int getSeats() {
        return 1000;
    }

}
