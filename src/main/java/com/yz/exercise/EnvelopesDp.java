package com.yz.exercise;

import java.util.Arrays;

/**
 * @author yu.zh-neu
 * @create 2023-06-19 18:03
 */
public class EnvelopesDp {
    public static void main(String[] args) {
        int[][] envelopes = {
                {3, 10},
                {3, 5},
                {4, 8},
                {5, 7},
                {4, 7},
                {5, 8},
                {6, 9},
                {7, 11},
                {8, 10},
                {8, 9},
                {9, 10},
                {10, 12}
        };
        int num = maxEnvelopes(envelopes);
        System.out.println(num);
    }

    public static int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0) {
            return 0;
        }
        // 宽度从小到大，高度从大到小排序
        Arrays.sort(envelopes, (env1, env2) -> {
            if (env1[0] == env2[0]) {
                return env2[1] - env1[1];
            } else {
                return env1[0] - env2[0];
            }
        });
        return lengthOfLIS(envelopes);
    }

    public static int lengthOfLIS(int[][] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i][1] > nums[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // 定义状态dp[i]表示以第i个信封为结尾的最长递增子序列的长度
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
