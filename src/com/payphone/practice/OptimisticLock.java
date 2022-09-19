package com.payphone.practice;

import java.util.concurrent.atomic.AtomicLong;

public class OptimisticLock {
    public static AtomicLong lock = new AtomicLong(0); //0代表解锁，1代表上锁

    public static void main(String[] args) throws InterruptedException {
        Stock stock = new Stock();
        stock.setId(1);
        stock.setCode("1001");
        stock.setCount(1000);
        stock.setVersion(1);
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                while (lock()) {
                    int count = stock.getCount() - 1;
                    int version = stock.getVersion() + 1;
                    stock.setCount(count);
                    stock.setVersion(version);
                    System.out.println(stock);
                    break;
                }
                unlock();
            }).start();
        }

    }

    public static boolean lock() {
        while (!lock.compareAndSet(0, 1)) ;
        return true;
    }

    public static boolean unlock() {
        lock.compareAndSet(1, 0);
        return true;
    }
}


