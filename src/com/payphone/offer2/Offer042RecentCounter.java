package com.payphone.offer2;


import java.util.LinkedList;

public class Offer042RecentCounter {
    static class RecentCounter {
        private LinkedList<Integer> queue;

        public RecentCounter() {
            queue = new LinkedList<>();
        }

        // 在 t 时刻发送了一个请求。并返回最近 3000ms 内的请求总数。
        public int ping(int t) {
            while (!queue.isEmpty() && t - queue.getFirst() > 3000) {
                queue.pop();
            }
            queue.addLast(t);
            return queue.size();
        }
    }

    public static void main(String[] args) {
        RecentCounter soultion = new RecentCounter();
        soultion.ping(1);
        soultion.ping(100);
        soultion.ping(3001);
        soultion.ping(3002);
    }
}
