package com.payphone.offer;

public class Offer004FindNumberIn2DArray {
    // 暴力解题
    public boolean findNumberIn2DArray1(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == target) return true;
            }
        }
        return false;
    }

    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        if (matrix.length == 0 && matrix.length == 0) return false;

        for (int i = 0, j = matrix[0].length - 1; i < matrix.length && j >= 0; ) {
            if (target == matrix[i][j]) return true;
                // matrix比target大，则纵轴剪
            else if (target < matrix[i][j]) j--;
            else i++;

        }
        return false;
    }

    /**
     * 暴力双重 for,效率好像更高，cache 缓存
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean findNumberIn2DArrayLH(int[][] matrix, int target) {

        return false;
    }
}
