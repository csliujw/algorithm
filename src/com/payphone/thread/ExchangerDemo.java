package com.payphone.thread;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExchangerDemo {

    private static void sleep(int time) {
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        final Exchanger exchanger = new Exchanger();
        executor.execute(() -> {
            try {
                String data1 = "AK47";
                sleep(5);
                System.out.println(Thread.currentThread().getName() + "扔了" + data1);
                data1 = exchanger.exchange(data1).toString();
                System.out.println(Thread.currentThread().getName() + "捡到了" + data1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executor.execute(() -> {
            try {
                String data1 = "AWM";
                System.out.println(Thread.currentThread().getName() + "扔了" + data1);
                data1 = exchanger.exchange(data1).toString();
                System.out.println(Thread.currentThread().getName() + "捡到了" + data1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executor.shutdown();
    }

}