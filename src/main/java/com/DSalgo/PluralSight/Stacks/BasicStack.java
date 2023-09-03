package com.DSalgo.PluralSight.Stacks;

public class BasicStack implements Stack {

    public static void main(String[] args) {

        Stack stack = new BasicStack();
        stack.push("Hello");

        Object item = stack.pop();

    }

    @Override
    public void push(Object item) {

    }

    @Override
    public Object pop() {
        return null;
    }

    @Override
    public boolean contains(Object item) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Object access(Object item) {
        return null;
    }
}
