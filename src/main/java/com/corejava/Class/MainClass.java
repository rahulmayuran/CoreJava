package com.corejava.Class;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MainClass {

    public static void main(String args[]) {
        main(122);
        main('f');
        main("hello java");
    }

    public static void main(int i) {
        log.info("Overloaded main()" + i);
    }

    public static void main(char i) {
        log.info("Overloaded main() again" + i);
    }

    public static void main(String str) {
        log.info("Overloaded main() once again" + str);
    }

}
