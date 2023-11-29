package com.yz.exercise;

import java.util.Scanner;

/**
 * 输入
 * 第一行输入m，n表示长宽，满足1< mn <= 2:后面输入m行，每行有n个0或1的整数，整数间使用一人空格隔开表示该行已停车情况，其中 0 表示空位，1 表示已停。
 * 输出
 * 最少需要打开监控器的数量
 * @author yu.zh-neu
 * @create 2023-09-05 19:45
 */
public class VideoProblem {

    static int rowCount, colCount; // 行数和列数
    static int[][] grid = new int[25][25];
    static final int[][] DIRECTIONS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}, {0, 0}}; // 方向数组，用于遍历相邻格子

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        rowCount = scanner.nextInt(); // 读入行数
        colCount = scanner.nextInt(); // 读入列数
        for (int row = 1; row <= rowCount; row++) { // 读入地图
            for (int col = 1; col <= colCount; col++) {
                grid[row][col] = scanner.nextInt();
            }
        }

        int result = 0;
        for (int row = 1; row <= rowCount; row++) { // 遍历每个格子
            for (int col = 1; col <= colCount; col++) {
                if (grid[row][col] == 1) { // 如果当前格子是车，直接计入结果
                    result++;
                    continue;
                }
                // 否则，遍历相邻的格子
                if (row > 1 && grid[row - 1][col] == 1 || // 上方格子
                        row < rowCount && grid[row + 1][col] == 1 || // 下方格子
                        col > 1 && grid[row][col - 1] == 1 || // 左侧格子
                        col < colCount && grid[row][col + 1] == 1 || // 右侧格子
                        grid[row][col] == 1) { // 当前格子本身是车
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}
