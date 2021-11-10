package com.payphone.ds.stack;

public interface Stack<E> {
    void push(E e);

    E pop();

    E peek();

    int getSize();

    boolean isEmpty();
}
