package com.payphone.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Sale3 {

    private static void sleep(int time) {
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ThreadLocal<Integer> threadVar = new ThreadLocal<>();
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            executor.submit(() -> {
                threadVar.set(100);
                sleep(1);
            });
        }
        sleep(2); //
        for (int i = 0; i < 3; i++) {
            Future<?> submit = executor.submit(() -> {
                while (threadVar.get() > 0) {
                    threadVar.set(threadVar.get() - 1);
                }
            });
        }
        sleep(2);
        for (int i = 0; i < 3; i++) {
            executor.submit(() -> {
                System.out.println(threadVar.get());
            });
        }
        executor.shutdown();
    }
}
