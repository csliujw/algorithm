package com.payphone.offer;

/**
 * 矩阵中的字符串s
 */
public class Offer012Exist {

    public boolean exist(char[][] board, String word) {
        boolean ans = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                ans = helper(board, word, i, j, 0);
                if (ans) break;
            }
        }
        return ans;
    }

    private boolean helper(char[][] board, String word, int col, int row, int index) {
        // 上下左右四个方向进行枚举。
        if (col < 0 || row < 0 || col > board.length || row > board[0].length || board[col][row] != word.charAt(index))
            return false;
        if (index >= word.length() - 1) return true;
        // 上
        char tmp = board[col][row];
        board[col][row] = '\0';
        boolean ans = helper(board, word, col - 1, row, index + 1)
                || helper(board, word, col + 1, row, index + 1)
                || helper(board, word, col, row - 1, index + 1)
                || helper(board, word, col, row + 1, index + 1);
        board[col][row] = tmp;
        return ans;
    }
}
