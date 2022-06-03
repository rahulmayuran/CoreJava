package com.corejava.Class;

import static com.BaseLogger.Logger.commmonLogger;

public class MainClass {

    public static void main(String args[]) {
        main(122);
        main('f');
        main("hello java");
    }

    public static void main(int i) {
        commmonLogger.info("Overloaded main()" + i);
    }

    public static void main(char i) {
        commmonLogger.info("Overloaded main()" + i);
    }

    public static void main(String str) {
        commmonLogger.info("Overloaded main()" + str);
    }

}
