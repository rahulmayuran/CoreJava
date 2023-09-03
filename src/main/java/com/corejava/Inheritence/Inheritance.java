package com.corejava.Inheritence;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Inheritance {

    public int seats = 12;

    public Inheritance(int seats) {
        log.info(seats + " <-From constructor");
    }

    public static void main(String[] args) {

        Inheritance iclass = new Inheritance(10);
        log.info(String.valueOf(iclass.seats)); // 12

        InheritedClass jclass = new InheritedClass(10); // This calls the super() which prints the
        // constructor of parent class and the constructor of child class
        log.info(String.valueOf(jclass.seats)); // 100

        log.info(iclass.getSeats()); // 120
        log.info(jclass.getSeats()); // 1000

        // Tricky part
        Inheritance kclass = new InheritedClass(10);
        log.info(String.valueOf(kclass.seats)); // 12
        log.info(kclass.getSeats()); // 120 must be printed, But 1000 will be printed because of
        // method overriding
        log.info(String.valueOf(kclass instanceof Inheritance)); // true
        log.info(String.valueOf(kclass instanceof InheritedClass)); // true


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
