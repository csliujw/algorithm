package com.payphone.leetcode;

public class N0883ProjectionArea {

    public int projectionArea(int[][] grid) {
        int noZero = 0;
        int rowMaxSum = 0;
        int colMaxSum = 0;
        for (int i = 0; i < grid.length; i++) {
            int rowMax = 0;
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0) noZero++;
                rowMax = Math.max(rowMax, grid[i][j]);
            }
            rowMaxSum += rowMax;
        }

        for (int i = 0; i < grid.length; i++) {
            int colMax = 0;
            for (int j = 0; j < grid[i].length; j++) {
                colMax = Math.max(colMax, grid[j][i]);
            }
            colMaxSum += colMax;
        }

        return noZero + rowMaxSum + colMaxSum;
    }
}
