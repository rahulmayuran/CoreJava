package com.corejava.Class;

public class MainClass {

    public static void main(String args[]) {
        main(122);
        main('f');
        main("hello java");
    }

    public static void main(int i) {
        System.out.println("Overloaded main()" + i);
    }

    public static void main(char i) {
        System.out.println("Overloaded main()" + i);
    }

    public static void main(String str) {
        System.out.println("Overloaded main()" + str);
    }

}
