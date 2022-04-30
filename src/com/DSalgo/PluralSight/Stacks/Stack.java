package com.DSalgo.PluralSight.Stacks;

public interface Stack<X> {

    public void push(X item);
    public X pop();
    public boolean contains(X item);
    public int size();
    public X access(X item);
    }

