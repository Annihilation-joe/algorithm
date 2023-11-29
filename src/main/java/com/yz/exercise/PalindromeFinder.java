package com.yz.exercise;

/**
 * @author yu.zh-neu
 * @create 2023-06-19 17:47
 */
public class PalindromeFinder {

    public static void main(String[] args) {
        int maxLength = longestPalindromeSubseq("abskddsbdesbnba");
        System.out.println(maxLength);
    }


    public static int longestPalindromeSubseq(String s) {
        int length = s.length();
        int[][] dp = new int[length][length];
        //这里i要从最后一个开始遍历
        for (int i = length - 1; i >= 0; i--) {
            //单个字符也是一个回文串
            dp[i][i] = 1;
            //j从i的下一个开始
            for (int j = i + 1; j < length; j++) {
                //下面是递推公式
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][length - 1];
    }

}
