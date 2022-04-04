package com.payphone.thread;

/**
 * N 个线程顺序打印 0 ~ 100
 * N 个线程的话，用同步做就不方便了。
 */
public class NPrint {
    private int count = 0;

    public static void main(String[] args) {
        NPrint nPrint = new NPrint();
        Thread n1 = new Thread(() -> {
            nPrint.print();
        });
        Thread n2 = new Thread(() -> {
            nPrint.print();
        });
        Thread n3 = new Thread(() -> {
            nPrint.print();
        });
        Thread n4 = new Thread(() -> {
            nPrint.print();
        });
        n1.start();
        n2.start();
        n3.start();
        n4.start();
    }

    public void print() {
        while (count <= 100) {
            synchronized (this) {
                if (count <= 100) System.out.println(count++);
            }
        }
    }
}
