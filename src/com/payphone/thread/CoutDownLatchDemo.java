package com.payphone.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CoutDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);

        new Thread(() -> {
            try {
                countDownLatch.await();
                System.out.println("111");
            } catch (Exception e) {

            }
        }).start();

        TimeUnit.SECONDS.sleep(1);
        System.out.println("111");
        countDownLatch.countDown();

    }
}
