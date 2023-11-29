package com.yz.exercise;
import java.util.Scanner;

/**
 * @author yu.zh-neu
 * @create 2023-09-07 15:16
 */
public class LagestLengthSubStr {

    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(System.in);
            String inputStr = scan.nextLine();
            if (inputStr == null || inputStr.length() == 0) {
                System.out.println("-1");
                return;
            }
            char[] chars = inputStr.toCharArray();
            for (char c : chars) {
                if (!(('0' <= c && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) {
                    System.out.println("-1");
                    return;
                }
            }
            int leftIndex = 0;
            int rightIndex = 1;
            int max = -1;
            while (rightIndex < inputStr.length() && leftIndex < inputStr.length()) {
                ++rightIndex;
                String subStr = inputStr.substring(leftIndex, rightIndex);
                boolean flag;
                String replaceStr = subStr.replaceAll("[0-9]", "");
                flag = replaceStr.length() != subStr.length() && replaceStr.length() <= 1;
                if (flag) {
                    max = Math.max(max, subStr.length());
                } else {
                    leftIndex++;
                }
            }
            System.out.println(max);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("-1");
        }
    }
}

