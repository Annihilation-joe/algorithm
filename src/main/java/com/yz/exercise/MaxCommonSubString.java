package com.yz.exercise;

import java.util.Arrays;

/**
 * @author yu.zh-neu
 * @create 2023-06-26 11:20
 */
public class MaxCommonSubString {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 2, 1};
        int[] b = new int[]{3, 2, 1, 4, 7};
        int length = findLength(a, b);
        System.out.println(length);
    }

    public static int findLength(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int maxLength = 0;

        // 使用一维数组dp，dp[j]表示以A[i-1]和B[j-1]结尾的最长公共子数组的长度
        int[] dp = new int[n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = n; j >= 1; j--) {
                if (A[i - 1] == B[j - 1]) {
                    dp[j] = dp[j - 1] + 1;
                    maxLength = Math.max(maxLength, dp[j]);
                } else {
                    // 如果A[i-1]和B[j-1]不相等，则当前位置的最长公共子数组长度为0
                    dp[j] = 0;
                }
            }
        }

        return maxLength;
    }

    public static int findLength2(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int maxLength = 0;

        // 创建一个二维数组dp，dp[i][j]表示以A[i-1]和B[j-1]结尾的最长公共子数组的长度
        int[][] dp = new int[m + 1][n + 1];

        // 遍历数组A和B，填充dp数组
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
            }
        }
        return maxLength;
    }
}
