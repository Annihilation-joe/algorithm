package com.yz.exercise;

/**
 * 给你一个字符串s、一个字符串t。返回s中涵盖t所有字符的最小子串。如果s中不存在涵
 * 盖t所有字符的子串，则返回空字符串" "。
 *
 * @author yu.zh-neu
 * @create 2023-07-20 14:41
 */
public class FindlestSubString {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        String str = minWindow(s, t);
        System.out.println(str);
    }

    private static String minWindow(String s, String t) {
        int[] map = new int[128];
        //记录字符串t中每个字符的数量
        for (char ch : t.toCharArray()) {
            map[ch]++;
        }
        //字符串t的数量
        int count = t.length();
        int left = 0;//窗口的左边界
        int right = 0;//窗口的右边界
        //覆盖t的最小长度
        int windowLength = Integer.MAX_VALUE;
        //覆盖字符串t开始的位置
        int strStart = 0;
        while (right < s.length()) {
            if (map[s.charAt(right++)]-- > 0) {
                count--;
            }
            //如果全部覆盖
            while (count == 0) {
                //如果有更小的窗口就记录更小的窗口
                if (right - left < windowLength) {
                    windowLength = right - left;
                    strStart = left;
                }
                if (map[s.charAt(left++)]++ == 0) {
                    count++;
                }
            }
        }
        if (windowLength != Integer.MAX_VALUE) {
            return s.substring(strStart, strStart + windowLength);
        }
        return "";
    }
}
