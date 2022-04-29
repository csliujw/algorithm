package com.payphone.offer;

import org.junit.Test;

import java.util.PriorityQueue;

public class Offer033VerifyPostorder {
    public boolean verifyPostorder(int... postorder) {
        return verify(postorder, 0, postorder.length - 1);
    }

    private boolean verify(int[] postorder, int start, int end) {
        if (start >= end - 1) return true;
        int root = postorder[end];
        int left = -1, right;
        // 找到 left 的位置
        for (int i = start; i < end; i++) {
            if (postorder[i] > root) break;
            left = i;
        }
        if (left == -1) right = start;
        else right = left + 1;
        // 判断 right 的位置是否都符合要求
        for (int i = right; i < end; i++) {
            if (postorder[i] < root) return false;
        }

        return verify(postorder, start, left) && verify(postorder, right, end-1);
    }

    @Test
    public void f1() {
        System.out.println(verifyPostorder(4, 8, 6, 12, 16, 14, 10));
    }
}
