package com.payphone.leetcode;

public class _48_Rotate {

    public void rotate(int[][] matrix) {
        // 先按水平对称交换。
        for (int i = 0, j = matrix.length - 1; i < j; i++, j--) {
            for (int k = 0; k < matrix[i].length; k++) {
                int tmp = matrix[i][k];
                matrix[i][k] = matrix[j][k];
                matrix[j][k] = tmp;
            }
        }

        // 在对角线交换
        for (int i = 0; i < matrix.length/2; i++) {
            for (int j = 0; j < matrix.length; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}
