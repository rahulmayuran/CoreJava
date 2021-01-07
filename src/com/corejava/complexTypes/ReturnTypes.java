package com.corejava.complexTypes;

public class ReturnTypes {

    private int x = 12;
    private int y = 15;

    public static void main(String[] args) {

        ReturnTypes sum = new ReturnTypes();
        System.out.println(sum.sumOf());
    }

    public boolean sumOf() {
        int total = 18;
        return total < x + y;
    }

}
