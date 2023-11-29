package com.yz.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yu.zh-neu
 * @create 2023-06-27 20:03
 */
public class EightQueensProblem {
    public static List<int[]> solveNQueens(int n) {
        List<int[]> solutions = new ArrayList<>();
        int[] queens = new int[n]; // 存储每一行皇后的列索引

        backtrack(0, queens, solutions);
        return solutions;
    }

    private static void backtrack(int row, int[] queens, List<int[]> solutions) {
        int n = queens.length;

        if (row == n) {
            solutions.add(queens.clone());
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValidPosition(row, col, queens)) {
                queens[row] = col;
                backtrack(row + 1, queens, solutions);
            }
        }
    }

    private static boolean isValidPosition(int row, int col, int[] queens) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col || queens[i] - queens[row] == i - row || queens[i] - queens[row] == row - i) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 8;
        List<int[]> solutions = solveNQueens(n);
        for (int[] solution : solutions) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (solution[i] == j) {
                        System.out.print("Q ");
                    } else {
                        System.out.print(". ");
                    }
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
