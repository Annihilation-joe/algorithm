package com.yz.exercise;

import java.util.Scanner;

/**
 * 华为面试 去除空格
 * @author yu.zh-neu
 * @create 2023-07-29 19:30
 */
public class SpaceSpiltProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String text = scanner.nextLine();
            String s = text.substring(6, text.length() - 1);
            String[] words = s.trim().split("\\s+");
            int wordCount = words.length;
            int spaceCount = text.length() - text.replaceAll(" ", "").length();

            if (wordCount == 1) {
                System.out.println(words[0] + repeatString(" ", spaceCount));
            }
            for (String word : words) {
                System.out.println("#" +word+ "#");
            }
            int avgSpace = spaceCount / (wordCount - 1);
            int extraSpace = spaceCount % (wordCount - 1);

            StringBuilder result = new StringBuilder();
            for (int i = 0; i < words.length; i++) {
                result.append(words[i]);
                if (i < words.length - 1) {
                    result.append(repeatString(" ", avgSpace));
                }
            }
            result.append(repeatString(" ", extraSpace));

            System.out.println(result.toString());
        }

    }
    private static String repeatString(String str, int repeatCount) {
        if (repeatCount <= 0) {
            return "";
        }

        StringBuilder result = new StringBuilder(str.length() * repeatCount);
        for (int i = 0; i < repeatCount; i++) {
            result.append(str);
        }

        return result.toString();
    }

}
