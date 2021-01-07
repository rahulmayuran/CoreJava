package com.corejava.complexTypes;

public class classMethodConstructor {

    //fields that has a state
    int passengers;
    int seats;

    /*
     * 1. constructor is special method that is called when an object is instantiated
     * It means that if you use new keyword , The constructor will initialize the
     * objects/fields of the class
     * 2. It cannot be abstract, final , static or synchronized
     */

    public classMethodConstructor() {
        passengers = 0;
        seats = 200;
    }

    public static void main(String[] args) {

        classMethodConstructor flight1 = new classMethodConstructor();
        classMethodConstructor flight2 = new classMethodConstructor();
        flight1.addPassenger();
        System.out.println("The amount of passengers for flight1 is " + flight1);

        flight1 = flight2; // flight 1 points to the references of objects of flight 2
        System.out.println("The amount of passengers for flight1 is " + flight1);
        flight2.addPassenger();
        flight2.addPassenger();
        System.out.println("The amount of passengers for flight 2 is " + flight2);
        System.out.println("The amount of passengers for flight1 is " + flight1);

        flight2.floatSum(2.5f, 4.5f, 0);

    }

    //Methods will perform activities with objects and changes it's state
    //It needs to return something if it is not void
    public void addPassenger() {
        passengers += 1;
    }

    public void floatSum(float x, float y, int count) {
        if (count < 1) {
            System.out.println("Returned back as the count is less than 1");

        } else {

            float sum = x + y;
            for (int i = 0; i < count; ++i) {
                System.out.println(sum);
            }
        }

    }

    @Override
    public String toString() {
        return "classMethodConstructor [passengers=" + passengers + ", seats=" + seats + "]";
    }

}
