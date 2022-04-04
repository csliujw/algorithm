package com.payphone.thread;

import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 单生产者单消费者问题
 * 使用 Java 的同步阻塞队列来实现生产者消费者问题的安全。
 */
public class ProductAndConsumer {
    static ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
    static int count = 0;

    public static void main(String[] args) {
        Thread p1 = new Thread(new Product());
        Thread p2 = new Thread(new Product());
        Thread c1 = new Thread(new Consumer());
        Thread c2 = new Thread(new Consumer());
        p1.start();
        p2.start();
        c1.start();
        c2.start();
    }

    static class Product implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 30; i++) {
                try {
                    queue.put(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("生产一个" + i);
            }
        }
    }

    static class Consumer implements Runnable {
        @Override
        public void run() {
            while (true) {
                Integer i = null;
                try {
                    i = queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("消费一个" + i);
            }
        }
    }

    static class BlockQueue<R> {
        private LinkedList<R> queue;
        private int capacity;

        public BlockQueue() {
            this(10);
        }

        public BlockQueue(int capacity) {
            queue = new LinkedList<>();
            this.capacity = capacity;
        }

        public synchronized void add(R r) {
            while (true) {
                if (queue.size() < capacity) {
                    queue.addLast(r);
                    this.notifyAll();
                    return;
                } else {
                    this.notifyAll();// 唤醒队列的 get 方法
                    try {
                        this.wait(); // 阻塞
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public synchronized R get() {
            while (true) {
                if (queue.size() > 0) {
                    R r = queue.removeFirst();
                    this.notifyAll();
                    return r;
                } else {
                    try {
                        this.notifyAll();
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

