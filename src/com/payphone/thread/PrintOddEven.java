package com.payphone.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 两个交替打印奇偶。
 * A线程打印奇数，B线程打印偶数。
 * 先打印偶数，偶数打完一次后，唤醒打印奇数的线程。
 */
public class PrintOddEven {
    ReentrantLock lock = new ReentrantLock();
    Condition oddBlock = lock.newCondition(); // 奇数
    Condition evenBlock = lock.newCondition(); // 偶数
    static volatile int count = 0;

    public static void main(String[] args) {
        PrintOddEven printOddEven = new PrintOddEven();
        Thread th1 = new Thread(() -> {
            printOddEven.printOdd();
        });
        Thread th2 = new Thread(() -> {
            printOddEven.printEven();
        });

        th1.start();
        th2.start();
    }

    void printOdd() {
        while (count < 100) {
            try {
                lock.lock();
                if (count % 2 != 0) {
                    System.out.println(count++);
                }
                evenBlock.signalAll();
                oddBlock.await();
            } catch (InterruptedException e) {
            } finally {
                lock.unlock();
            }
        }
    }

    void printEven() {
        while (count <= 100) {
            try {
                lock.lock();
                if (count % 2 == 0) {
                    System.out.println(count++);
                }
                if (count == 101) {
                    oddBlock.signalAll();
                } else {
                    oddBlock.signalAll();
                    evenBlock.await();
                }
            } catch (InterruptedException e) {
            } finally {
                lock.unlock();
            }
        }
    }
}
