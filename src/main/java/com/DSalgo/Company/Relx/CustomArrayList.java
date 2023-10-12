package com.DSalgo.Company.Relx;

import java.util.ArrayList;

public final class CustomArrayList<X> extends ArrayList<X> {

    //We are overriding the actual add() method of ArrayList
    //We are using the contains() method from ArrayList again.
    //We are using the super keyword to refer the ArrayList class's add method.

    @Override
    public boolean add(X el) {
        if(!contains(el)){
            return super.add(el);
        }
        return false;
    }
}
