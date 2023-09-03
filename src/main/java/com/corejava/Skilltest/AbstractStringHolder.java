package com.corejava.Skilltest;

public abstract class AbstractStringHolder {

    public abstract String get();

    public boolean isEmpty() {
        return get() == null;
    }
}

	