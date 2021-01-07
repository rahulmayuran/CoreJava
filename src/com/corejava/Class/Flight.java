package com.corejava.Class;

public class Flight {

    int flightNumber;

    public Flight(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    //made it static as it should be called in main method
    static void swap(Flight i, Flight j) {
        Flight k = i; //k becomes 10 as i references f1
        i = j; //i becomes 20 as j references f2
        j = k; //j becomes 10 as k references i is 10
        //k.setFlightNumber(i.getFlightNumber());
        //If the line is uncommented, the output will be 20/20/20
        System.out.println("i-> " + i + "j-> " + j + "k-> " + k);
    }

    public static void main(String[] args) {
        Flight f1 = new Flight(10);
        Flight f2 = new Flight(20);
        //Here f1 and f2 allocates memory to Flight objects with values 10 & 20
        System.out.println("Flight1 ->" + f1);
        System.out.println("Flight2 ->" + f2);
        //System.out.println('j'�+�'a'�+�'v'�+�'a');

        swap(f1, f2);
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    @Override
    public String toString() {
        return "Flight [flightNumber=" + flightNumber + "]";
    }

}
