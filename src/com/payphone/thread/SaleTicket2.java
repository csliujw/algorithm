package com.payphone.thread;

import java.sql.Time;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class SaleTicket2 {
    private static AtomicInteger ticket = new AtomicInteger(200);

    public void sale() {
        int old = -1;
        while ((old = ticket.get()) > 0) {
            try {
                TimeUnit.MILLISECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!ticket.compareAndSet(old, old - 1)) ;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SaleTicket2 sale = new SaleTicket2();
        Thread th1 = new Thread(() -> {
            sale.sale();
        });
        Thread th2 = new Thread(() -> {
            sale.sale();
        });
        Thread th3 = new Thread(() -> {
            sale.sale();
        });
        th1.start();
        th2.start();
        th3.start();
        th1.join();
        th2.join();
        th3.join();

        System.out.println(ticket.get());
    }
}