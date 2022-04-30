package com.payphone.offer;

public class Offer015HammingWeight {
    public int hammingWeight(int n) {
        int flag = 1;
        int count = 0;
        // 对n进行移位的话，会导致死循环。
        for (int i = 0; i < 32; i++) {
            if ((n & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }
}
