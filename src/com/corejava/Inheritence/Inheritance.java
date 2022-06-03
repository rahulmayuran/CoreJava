package com.corejava.Inheritence;

import static com.BaseLogger.Logger.commmonLogger;

public class Inheritance {

    public int seats = 12;

    public Inheritance(int seats) {
        commmonLogger.info(seats + " <-From constructor");
    }

    public static void main(String[] args) {

        Inheritance iclass = new Inheritance(10);
        commmonLogger.info(String.valueOf(iclass.seats)); // 12

        InheritedClass jclass = new InheritedClass(10); // This calls the super() which prints the
        // constructor of parent class and the constructor of child class
        commmonLogger.info(String.valueOf(jclass.seats)); // 100

        commmonLogger.info(iclass.getSeats()); // 120
        commmonLogger.info(jclass.getSeats()); // 1000

        // Tricky part
        Inheritance kclass = new InheritedClass(10);
        commmonLogger.info(String.valueOf(kclass.seats)); // 12
        commmonLogger.info(kclass.getSeats()); // 120 must be printed, But 1000 will be printed because of
        // method overriding
        commmonLogger.info(String.valueOf(kclass instanceof Inheritance)); // true
        commmonLogger.info(String.valueOf(kclass instanceof InheritedClass)); // true


		 /* This below code will not compile as the child class cannot take ownership of
		  parent class and can't modify the properties.*/

//		  InheritedClass hclass = new Inheritance(10);
//		  commmonLogger.info(hclass.seats); //12
//		  commmonLogger.info(hclass.getSeats());
//		  //120 must be printed, But 1000 will be printed because of method
//		  commmonLogger.info(hclass instanceof Inheritance); //true
//		  commmonLogger.info(hclass instanceof InheritedClass); //true
    }

    String getSeats() {
        return "120";
    }

}
