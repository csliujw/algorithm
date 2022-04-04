package com.payphone.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

// 使用 ReentrantLock 完成顺序打印 n 次 ABC
// 如何确保 ABC 依此打印？用一个变量控制，打印 A 还是 B 还是 C。
// 三个线程抢占打印。抢到的线程按条件打印对应的字母，然后唤醒被阻塞的线程
public class PrintABCReentrantLock {
    static ReentrantLock lock = new ReentrantLock();
    static Condition blockA = lock.newCondition();
    static Condition blockB = lock.newCondition();
    static Condition blockC = lock.newCondition();
    static volatile int n = 1;

    public static void printA() {
        while (n <= 60) {
            try {
                lock.lock();
                if (n % 3 == 1) {
                    System.out.print("A");
                    n++;
                }
                blockB.signal();
                blockA.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void printB() {
        while (n <= 60) {
            try {
                lock.lock();
                if (n % 3 == 2) {
                    System.out.print("B");
                    n++;
                }
                blockC.signal();
                blockB.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void printC() {
        while (n <= 60) {
            try {
                lock.lock();
                if (n % 3 == 0) {
                    System.out.print("C");
                    n++;
                }
                if (n == 61) {
                    blockA.signal();
                    blockB.signal();
                } else {
                    blockA.signal();
                    blockC.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
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
    }
}