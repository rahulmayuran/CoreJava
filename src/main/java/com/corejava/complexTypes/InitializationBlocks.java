package com.corejava.complexTypes;

public class InitializationBlocks {

    private int passengers = 100, flightNumber = 7887, seats = 150;
    private char flightClass = 'F';
    private boolean[] isSeatAvailable;

    public InitializationBlocks() {

        isSeatAvailable = new boolean[seats];
        for (int o = 0; o < seats; o++) {
            isSeatAvailable[o] = true;
        }
    }

    public InitializationBlocks(char flightClass) {
        this();
        this.flightClass = flightClass;
    }

    public InitializationBlocks(int flightnumber) {
        this();
        this.flightNumber = flightnumber;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
