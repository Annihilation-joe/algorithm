package com.yz.exercise;

import java.util.Arrays;

/**
 * @author yu.zh-neu
 * @create 2023-06-30 10:51
 */
public class SudoProblem {
    public static void main(String[] args) {
        int[][] board = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 5, 0, 0, 8, 0, 0, 7, 9}
        };
        boolean flag = solveSudoKu(board, 0, 0);
        System.out.println(flag);
    }

    public static boolean solveSudoKu(int[][] board, int row, int col) {
        boolean isEmpty = true;

        // 检查是否还有空格
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty) {
                break;
            }
        }

        // 如果没有空格了，数独已解决
        if (isEmpty) {
            return true;
        }
        for (int i = 1; i <= 9; i++) {
            if (!isValid(board, row, col, i)) {
                continue;
            }
            board[row][col] = i;
            if (solveSudoKu(board, row, col)) {
                return true;
            }
            board[row][col] = 0;
        }
        return false;
    }

    private static boolean isValid(int[][] board, int row, int col, int num) {
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == num) {
                return false;
            }
            if (board[i][col] == num) {
                return false;
            }
        }
        int m = row/3;
        int n = col/3;
        for (int i = m; i < m + 3; i++) {
            for (int j = n; j < n + 3; j++) {
                if (board[m][n] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}
