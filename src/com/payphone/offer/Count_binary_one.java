package com.payphone.offer;

/**
 * https://www.acwing.com/problem/content/25/
 * 二进制中1的个数
 */
public class Count_binary_one {
    public static void main(String[] args) {
        Count_binary_one demo = new Count_binary_one();
        int i = demo.NumberOf1(-2);
        System.out.println(i);
    }


    // 可能又负数，负数直接用&运算可能会造成死循环，所以不能直接和1做&
    public int NumberOf1(int n) {
        int flag = 1;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }
}
