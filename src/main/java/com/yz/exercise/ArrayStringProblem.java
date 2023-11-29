package com.yz.exercise;

import java.util.Scanner;

/**
 * 在字符数组中查找字符串的位置
 * 5
 * A,B,C,D,E
 * F,G,H,I,J
 * K,L,M,N,O
 * P,Q,R,S,T
 * U,V,W,X,Y
 * VQRMNID
 * @author yu.zh-neu
 * @create 2023-07-19 15:47
 */
public class ArrayStringProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        char[][] array = new char[n][n];
        for (int i = 0; i < n; i++) {
            String[] row = scanner.nextLine().split(",");
            for (int j = 0; j < n; j++) {
                array[i][j] = row[j].charAt(0);
            }
        }

        String target = scanner.nextLine();

        String result = findString(array, target);
        System.out.println(result);

        scanner.close();
    }

    private static String findString(char[][] array, String target) {

        int n = array.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (array[i][j] == target.charAt(0)) {
                    boolean[][] visited = new boolean[n][n];
                    String result = dfsSearch(array, target, i, j, 0, "", visited);
                    if (!result.equals("N")) {
                        return result.substring(1);
                    }
                }
            }
        }
        return "N";
    }

    private static String dfsSearch(char[][] array, String target, int row, int col, int index, String indices, boolean[][] visited) {
        if (index == target.length()) {
            return indices; // 找到目标字符串，返回位置下标字符串
        }

        int n = array.length;

        if (row < 0 || row >= n || col < 0 || col >= n || visited[row][col] || array[row][col] != target.charAt(index)) {
            return "N"; // 越界、已访问或字符不匹配，返回"N"
        }

        visited[row][col] = true;

        String result;

        result = dfsSearch(array, target, row - 1, col, index +1, indices + "," + row + "," + col, visited); // 上方相邻单元格
        if (!result.equals("N")) {
            return result;
        }

        result = dfsSearch(array, target, row + 1, col, index +1, indices + "," + row + "," + col, visited); // 下方相邻单元格
        if (!result.equals("N")) {
            return result;
        }

        result = dfsSearch(array, target, row, col - 1, index +1, indices + "," + row + "," + col, visited); // 左方相邻单元格
        if (!result.equals("N")) {
            return result;
        }

        result = dfsSearch(array, target, row, col + 1, index +1, indices + "," + row + "," + col, visited); // 右方相邻单元格
        if (!result.equals("N")) {
            return result;
        }

        visited[row][col] = false; // 回溯，重置visited状态

        return "N"; // 在数组中未找到目标字符串，返回"N"
    }
}
