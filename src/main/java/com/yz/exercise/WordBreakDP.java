package com.yz.exercise;

import java.util.Arrays;
import java.util.List;

/**
 * 动态规划拆分字符串
 * @author yu.zh-neu
 * @create 2023-07-13 9:59
 */
public class WordBreakDP {
    public static void main(String[] args) {
        String s = "catsandog";
        List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat", "an");
        boolean flag = wordBreakDP(s, wordDict);
        System.out.println(flag);
    }

    private static boolean wordBreakDP(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j,i))) {
                    dp [i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
