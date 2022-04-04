package com.payphone.thread;

import java.util.concurrent.*;

/**
 * 多线程+多核CPU提高效率
 */
public class MutilThreadAdvance {
    // 3 个线程并行执行 3个耗时的任务
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        paralla();
        serial();
    }

    private static void serial() throws ExecutionException, InterruptedException {
        ExecutorService threadPools = Executors.newFixedThreadPool(1);
        CountDownLatch waitCalculate = new CountDownLatch(1);
        long start = System.currentTimeMillis();
        threadPools.submit(() -> {
            sleep(2);
            sleep(2);
            sleep(2);
            waitCalculate.countDown();
        });
        waitCalculate.await();
        long end = System.currentTimeMillis();
        System.out.println((end - start) / 1000);
        threadPools.shutdown();
    }

    private static void sleep(int time) {
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void paralla() throws InterruptedException {
        ExecutorService threadPools = Executors.newFixedThreadPool(3);
        CountDownLatch countDownLatch = new CountDownLatch(3);
        long start = System.currentTimeMillis();
        threadPools.submit(() -> {
            sleep(2);
            countDownLatch.countDown();
        });
        threadPools.submit(() -> {
            sleep(2);
            countDownLatch.countDown();
        });
        threadPools.submit(() -> {
            sleep(2);
            countDownLatch.countDown();
        });
        countDownLatch.await();
        long end = System.currentTimeMillis();
        System.out.println((end - start) / 1000);
        threadPools.shutdown();
    }
}
