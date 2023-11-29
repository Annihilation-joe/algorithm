package com.yz.exercise;

import java.util.Scanner;

/**
 * 给定一个长度为 N的整数数组，表示一个选手在N 轮内选择的牌面分数选手基于规则选牌，请计算所有轮结束后其可以获得的最高总分数选择规则如下:
 * 1.在每轮里选手可以选择获取该轮牌面，则其总分数加上该轮牌面分数为其新的总分数
 * 2.选手也可不选择本轮牌面，直接跳到下一轮，此时将当前总分数还原为3轮前的总分数，若当前轮次小于等于3，则总分数置0
 * 3.选手初始总分数为 0，且必须依次参加每轮
 * 输入
 * 第一行为一个小写 逗号 分隔的字符串
 * 表示N轮的牌面分数
 * 1 <= N <= 20 分数值为整数 [-100,100]
 * 不考虑格式问题
 * 举例：
 * 1,-5,-6,4,3,6,-2
 * 11
 * @author yu.zh-neu
 * @create 2023-09-08 10:37
 */
public class MaxScore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(",");
        int[] nums = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }
        int max = solveDP(nums);
        System.out.println(max);
    }

    public static int solveDP(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i < 3) {
                dp[i] = Math.max(0, dp[i-1] + nums[i]);
            } else {
                dp[i] = Math.max(dp[i-3], dp[i-1] + nums[i]);
            }
        }
        return dp[nums.length-1];
    }

}
