package com.yz.exercise;

import java.util.Scanner;

/**
 * 实现一种整数编码方法，使得待编码的数字越小，编码后所占用的字节数越小。编码规则如下:
 * 1、编码时 7 位一组，每个字节的低 7位用于存储待编码数字的补码
 * 2、字节的最高位表示后续是否还有字节，置1表示后面还有更多的字节，置 0 表示当前字节为最后一个字节
 * 3、采用小端序编码，低位和低字节放在低地址上。
 * 4、编码结果按 16 进制数的字符格式输出，小写字母需转换为大写字母
 *
 * @author yu.zh-neu
 * @create 2023-09-06 10:48
 */
public class IntegerCodeProblem {


    static char[] charArray = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'K',
            'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    private static void solve(int number) {
        String numStr = Integer.toBinaryString(number);
        boolean statu;
        StringBuilder stringBuilder = new StringBuilder();
        // 这里需要先先找到低7位
        while (0 < numStr.length()) {
            if (7 < numStr.length()) {
                statu = true;
                // 这里2进制不足7位时补0
            } else {
                statu = false;
                int midIdx = 7 - numStr.length();
                for (int j = 0; j < midIdx; ++j) {
                    numStr = "0" + numStr;
                }
            }
            String subStr = numStr.substring(numStr.length() - 7);
            numStr = numStr.substring(0, numStr.length() - 7);
            if (statu) {
                subStr = "1" + subStr;
            } else {
                subStr = "0" + subStr;
            }
            String resultStr = Integer.toHexString(Integer.parseInt(subStr, 2));
            // 这里16进制不足2位补0
            if (2 > resultStr.length()) {
                resultStr = "0" + resultStr;
            }
            for (int j = 0; j < resultStr.length(); ++j) {
                char c = resultStr.charAt(j);
                if (c <= 'z' && c >= 'a') {
                    c = charArray[c - 'a'];
                }
                stringBuilder.append(c);
            }
        }
        // 每个字符如果是小写要转成大写
        System.out.println(stringBuilder);

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        solve(number);
    }
}

