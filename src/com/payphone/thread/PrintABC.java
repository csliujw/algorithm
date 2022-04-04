package com.payphone.thread;

// 使用 synchronized 完成顺序打印 n 次 ABC
// 如何确保 ABC 依此打印？用一个变量控制，打印 A 还是 B 还是 C。
// 三个线程抢占打印。抢到的线程按条件打印对应的字母，然后唤醒被阻塞的线程
public class PrintABC {
    static Object lock = new Object();
    static volatile int n = 1;

    public static void print() {
        for (int i = 0; i < 20; i++) {
            synchronized (lock) {
                if (n % 3 == 1) System.out.print("A");
                if (n % 3 == 2) System.out.print("B");
                if (n % 3 == 0) System.out.print("C");
                n++;
                lock.notifyAll(); // 唤醒其他线程一起抢占
            }
        }
    }


    public static void main(String[] args) {
        Thread th1 = new Thread(() -> {
            PrintABC.print();
        }, "1");
        Thread th2 = new Thread(() -> {
            PrintABC.print();
        }, "2");
        Thread th3 = new Thread(() -> {
            PrintABC.print();
        }, "3");
        th1.start();
        th2.start();
        th3.start();
    }
}