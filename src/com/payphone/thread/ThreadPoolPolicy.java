package com.payphone.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池拒绝策略
 */
public class ThreadPoolPolicy {
    // 抛弃
    static ThreadPoolExecutor pools = null;

    static {
        pools = new ThreadPoolExecutor(1, 1, 60,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(1),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
    }

    private static void sleep(int time) {
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void abortPolicy() {
        Runnable task = () -> {
            System.out.println("执行任务");
            sleep(30);
        };
        pools.submit(task);
        pools.submit(task);
        pools.submit(task);
        pools.submit(task);
        System.out.println(pools.getQueue().size());
    }

    public static void main(String[] args) {
        abortPolicy();
    }
}
