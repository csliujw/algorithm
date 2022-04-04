package com.payphone.thread;

/**
 * 多线程卖票
 */
public class SaleTicket {

    public static void main(String[] args) {
        Resource resource = new SaleTicket().new Resource();
        Thread th1 = new Thread(() -> {
            while (resource.getCount() > 0) resource.sale();
        });
        Thread th2 = new Thread(() -> {
            while (resource.getCount() > 0) resource.sale();
        });
        th1.start();
        th2.start();
    }

    // 多线程资源类
    class Resource {
        private volatile int count = 100;

        public int getCount() {
            return count;
        }

        public synchronized void sale() {
            if (count > 0) System.out.println("还剩：" + --count);
        }
    }
}


