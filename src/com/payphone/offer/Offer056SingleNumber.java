package com.payphone.offer;

import org.junit.Test;

public class Offer056SingleNumber {

    @Test
    public void f1() {
        System.out.println(singleNumber(9));
    }

    // 统计 bit 位。
    public int singleNumber(int... nums) {
        int[] bits = new int[31]; // 存储 bit 位为 1 的个数。
        // 怎么统计 bit 位呢？看最低的 bit 位是不是 1，看完后再右移动
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            int bit = 0;
            // 拿到 nums 所有 bit 位的值。
            while (cur != 0) { // 说明还有 bit 为 1的位置
                bits[bit] += (cur & 1);
                cur >>= 1;
                bit++;
            }
        }
        int ans = 0;
        for (int i = 0; i < bits.length; i++) {
            if (bits[i] % 3 != 0) {
                ans += (1 << i);
            }
        }
        return ans;
    }
}
