package com.payphone.thread;

import sun.security.krb5.internal.Ticket;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

// 使用 CAS 完成顺序打印 n 次 ABC
public class PrintABCCAS {
    static AtomicInteger increment = new AtomicInteger(1);

    public static void printA() {
        while (increment.get() < 58) {
            synchronized (PrintABC.class) {
                if (increment.get() % 3 == 1) {
                    System.out.print("A");
                    increment.getAndIncrement();
                }
            }
        }
    }

    public static void printB() {
        while (increment.get() < 59) {
            synchronized (PrintABC.class) {
                if (increment.get() % 3 == 2) {
                    System.out.print("B");
                    increment.getAndIncrement();
                }
            }
        }
    }

    public static void printC() {
        while (increment.get() < 60) {
            synchronized (PrintABC.class) {
                if (increment.get() % 3 == 0) {
                    System.out.print("C");
                    increment.getAndIncrement();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            Thread th1 = new Thread(() -> {
                printA();
            }, "1");
            Thread th2 = new Thread(() -> {
                printB();
            }, "2");
            Thread th3 = new Thread(() -> {
                printC();
            }, "3");
            th1.start();
            th2.start();
            th3.start();
            TimeUnit.MILLISECONDS.sleep(300);
//            TimeUnit.SECONDS.sleep(1);
            System.out.println();
            increment = new AtomicInteger(1);
        }

    }
}