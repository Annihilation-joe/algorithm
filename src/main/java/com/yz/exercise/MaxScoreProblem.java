package com.yz.exercise;

/**
 * 几张卡牌排成一行，每张卡牌都有一个对应的点数。点数由整数数组cardPoint s给出。
 * 每次行动，你可以从行的开头或者末尾拿一张卡牌，最终你必须正好拿k张卡牌。
 * 你的点数就是你拿到手中的所有卡牌的点数之和。
 * 给你一个整数数组cardPoint s和整数k，请你返回可以获得的最大点数。
 *
 * @author yu.zh-neu
 * @create 2023-07-19 19:21
 */
public class MaxScoreProblem {
    public static void main(String[] args) {
        int[] cardPoints = {10,79,70,1,1,9,100,50};
        int k = 3;
        int score = maxScore(cardPoints, k);
        System.out.println(score);
    }

    private static int maxScore(int[] cardPoints, int k) {
        int maxWindow = 0, length = cardPoints.length;
        //先统计前k个元素的和，也是窗口内元素的和
        for (int i = 0; i < k; i++) {
            maxWindow += cardPoints[i];
        }
        //然后窗口移动，更新当前窗口的值
        int temp = maxWindow;
        for (int i = length - 1; i >= length - k; i--) {
            //窗口移动的时候一个元素会出窗口，一个元素会进入窗口。
            //cardPoints[k - (length - i)]是移除窗口的元素
            temp -= cardPoints[k - (length - i)];
            //cardPoints[i]是进入窗口的元素
            temp += cardPoints[i];
            //记录窗口的最大值
            maxWindow = Math.max(maxWindow, temp);
        }
        return maxWindow;
    }
}
