package com.yz.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 判断字符串截取是否在字典中
 * @author yu.zh-neu
 * @create 2023-07-13 9:12
 */
public class WordBreakDFS {
    public static void main(String[] args) {
        String s = "catsandog";
        List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat", "an");
        boolean flag = wordBreakDFS(s, 0, wordDict);
        System.out.println(flag);
    }


    private static boolean wordBreakDFS(String s, int start, List<String> wordDict) {
        if (start == s.length()) {
            return true;
        }
        for (int i = start + 1; i <= s.length(); i ++ ) {
            System.out.println(s.substring(start, i));
            if (wordDict.contains(s.substring(start, i)) && wordBreakDFS(s, i, wordDict)) {
                return true;
            }
        }
        return false;
    }
}
