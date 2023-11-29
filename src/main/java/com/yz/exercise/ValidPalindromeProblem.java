package com.yz.exercise;

/**
 * 删除一个字符判断是否是回文串
 * @author yu.zh-neu
 * @create 2023-07-19 18:50
 */
public class ValidPalindromeProblem {
    public static void main(String[] args) {
        String s = "abca";
        boolean b = validPalindrome(s);
        System.out.println(b);
    }

    private static boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
            left ++ ;
            right -- ;
        }
        return true;
    }

    private static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
