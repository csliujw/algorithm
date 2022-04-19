package com.payphone.thread;

import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 阅读可重入锁的源码.
 * JDK8 和 JDK11 的源码出入挺大。JDK11 进行了代码的重构。
 * ReentrantLock#lock
 * ->sync#acquire(1) 尝试获取锁，如果获取失败则
 */
public class ReadReentrantLockSource {
    static volatile boolean flag = true;

    public static void sleep(long time) {
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // debug 查看加锁操作
    public static void t1() {
        ReentrantLock lock = new ReentrantLock();
        new Thread(() -> {
            lock.lock();
            sleep(2);
            System.out.println("阻塞了");
            lock.unlock();
        }).start();

        try {
            lock.lock();
            while (flag) ;
        } finally {
            lock.unlock();
        }
    }

    // debug 查看释放锁的操作。
    public static void t2() {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        lock.lock();
        // 查看可重入锁、
        lock.unlock();
        lock.unlock();
    }

    // debug 查看唤醒所有阻塞线程的操作
    public static void t3() {
        ReentrantLock lock = new ReentrantLock();
        Condition c1 = lock.newCondition();
        boolean A = true, B = true, C = true;
        // 启动，然后自己阻塞
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "：想拿锁了");
                lock.lock();
                c1.await();
                System.out.println(Thread.currentThread().getName() + "：拿到锁了");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "B").start();
        // 启动，然后自己阻塞
        sleep(1);
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "：想拿锁了");
                lock.lock();
                c1.await();
                System.out.println(Thread.currentThread().getName() + "：拿到锁了");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "C").start();

        sleep(2);
        // 拿到锁，唤醒所有被阻塞的线程
        new Thread(() -> {
            lock.lock();
            sleep(3);
            try {
                System.out.println("唤醒所有");
                while (A) ;
                c1.signalAll();
                c1.await();
                System.out.println("signalAll 后还可以执行");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "A").start();
        sleep(1);
    }

    public static void t4() {
        /**
         * 精准唤醒
         */
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        boolean flag = true;
        new Thread(() -> {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + ":阻塞了");
                condition.await();
                System.out.println("我被精准唤醒了");
                while (flag) ;
                lock.unlock();
            } catch (InterruptedException e) {
            }
        }, "先执行的线程").start();
        sleep(2);
        new Thread(() -> {
            try {
                lock.lock();
                condition.signal();
                condition.await();
                System.out.println("我精准唤醒了一个");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "后执行的线程").start();
    }

    public static void t5() {
        ReentrantLock lock = new ReentrantLock();
        Condition c = lock.newCondition();
        new Thread(() -> {
            try {
                lock.lock();
                c.await();
                System.out.println("被唤醒了");
                lock.unlock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();
        sleep(2);
        new Thread(() -> {
            lock.lock();
            c.signal();
            System.out.println("被唤醒了");
            lock.unlock();
        }, "B").start();
    }

    public static void main(String[] args) {
        t5();
    }
}
