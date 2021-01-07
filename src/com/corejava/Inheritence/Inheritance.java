package com.corejava.Inheritence;

public class Inheritance {

    public int seats = 12;

    public Inheritance(int seats) {
        System.out.println(seats + " <-From constructor");
    }

    public static void main(String[] args) {

        Inheritance iclass = new Inheritance(10);
        System.out.println(iclass.seats); // 12

        InheritedClass jclass = new InheritedClass(10); // This calls the super() which prints the
        // constructor of parent class and the constructor of child class
        System.out.println(jclass.seats); // 100

        System.out.println(iclass.getSeats()); // 120
        System.out.println(jclass.getSeats()); // 1000

        // Tricky part
        Inheritance kclass = new InheritedClass(10);
        System.out.println(kclass.seats); // 12
        System.out.println(kclass.getSeats()); // 120 must be printed, But 1000 will be printed because of
        // method overriding
        System.out.println(kclass instanceof Inheritance); // true
        System.out.println(kclass instanceof InheritedClass); // true


		 /* This below code will not compile as the child class cannot take ownership of
		  parent class and can't modify the properties.*/

//		  InheritedClass hclass = new Inheritance(10);
//		  System.out.println(hclass.seats); //12
//		  System.out.println(hclass.getSeats());
//		  //120 must be printed, But 1000 will be printed because of method
//		  System.out.println(hclass instanceof Inheritance); //true
//		  System.out.println(hclass instanceof InheritedClass); //true
    }

    int getSeats() {
        return 120;
    }

}
