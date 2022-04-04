package com.payphone.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class HowToCreateThread {
    private static void sleep(int time) {
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void callableFutureTask() throws ExecutionException, InterruptedException {
        Callable<Integer> callable = () -> {
            System.out.println("I am Callable");
            return 10;
        };

        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println(futureTask.get());
    }

    public static void runnable() {
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(i);
            }
        }).start();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        runnable();
    }
}
