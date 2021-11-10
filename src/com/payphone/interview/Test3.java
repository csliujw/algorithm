package com.payphone.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Test3 {
    private static class Coord {
        int x;
        int y;

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Coord{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    private double distance(Coord cur, Coord target) {
        double powX = Math.pow(cur.x - target.x, 2);
        double powY = Math.pow(cur.y - target.y, 2);
        return Math.sqrt(powX + powY);
    }

    public List<Coord> getNearestCoord(List<Coord> vec, Coord e, int k) {
        // 小堆.我们要用大堆.
        PriorityQueue<Coord> queue = new PriorityQueue<Coord>((o1, o2) -> {
            double d1 = distance(o1, e);
            double d2 = distance(o2, e);
            if (d1 == d2) return 0;
            if (d1 > d2) return -1;
            if (d1 < d2) return 1;
            return 0;
        });
        for (Coord coord : vec) {
            if (queue.size() < k) {
                queue.add(coord);
            } else {
                // 数目够了,和堆顶最大的元素进行比较.距离小于堆顶最大元素就替换
                if (distance(coord, e) < distance(queue.peek(), e)) {
                    queue.poll();
                    queue.add(coord);
                }
            }
        }
        return new ArrayList<>(queue);
    }

    public static void main(String[] args) {
        Coord target = new Coord(0, 0);
        Coord c1 = new Coord(1, 1);
        Coord c2 = new Coord(-1, -1);
        Coord c3 = new Coord(2, 2);
        Coord c4 = new Coord(3, 3);
        Coord c5 = new Coord(4, 4);
        ArrayList<Coord> list = new ArrayList<>();
        list.add(c1);
        list.add(c2);
        list.add(c3);
        list.add(c4);
        list.add(c5);
        Test3 test3 = new Test3();
        test3.getNearestCoord(list, target, 4).forEach(System.out::println);
    }

}
