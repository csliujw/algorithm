package com.payphone.thread;

class Demo {
    public static void main(String[] args) {
        synchronized (Demo.class) {
            System.out.println("Hello");
        }
    }
}
