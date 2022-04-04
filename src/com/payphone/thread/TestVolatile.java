package com.payphone.thread;

import java.sql.Time;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 设计一个代码，测试 Volatile 的可见性。
 * 准确说，这个是禁止了 JIT 优化。避免 while(flag) 被优化为 if(flag) while(true)
 */
public class TestVolatile {
    public static volatile boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.submit(() -> {
            while (flag) {
                // 停不下的循环
            }
        });
        TimeUnit.SECONDS.sleep(2);
        flag = false;
        executorService.shutdown();
    }
}
