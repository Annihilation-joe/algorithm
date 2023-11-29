package com.yz.exercise;

import java.util.Scanner;

/**
 * @author yu.zh-neu
 * @create 2023-09-07 17:17
 */
public class BitChange {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = scanner.nextInt();
        scanner.nextLine();

        String string1 = scanner.nextLine();
        String string2 = scanner.nextLine();

        int count1 = countOccurrences(string1, "1");
        int count0 = countOccurrences(string2, "0");
        int count01 = count01Occurrences(length, string1, string2);

        int result = (count1 - count01) * (count0 - count01) + (length - count1) *
                count01;
        System.out.println(result);

        scanner.close();
    }

    private static int countOccurrences(String str, String target) {
        int count = 0;
        int index = 0;
        while ((index = str.indexOf(target, index)) != -1) {
            count++;
            index += target.length();
        }
        return count;
    }

    private static int count01Occurrences(int length, String str1, String str2) {
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (str2.charAt(i) == '0' && str1.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }
}


