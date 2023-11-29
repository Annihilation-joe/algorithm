package com.yz.exercise;

import java.util.Scanner;

/**
 * 给定字符串 target和 source,判断 target 是否为 source 的子序列。你可以认为 target和 source 中仅包合英文小写字母，字符串 source 可能会很长(长度 ~= 500,000)，而 target是个短字符串(长度<=100)
 * 字符串的一人子序列是原始字符串删除一些(也可以不删除)字符而不改变剩余字符相对位置形成的新字符串。(例如，"abc"是"aebycd"的一个子序列，而"ayb"不是) 。
 * 请找出最后一个子序列的起始位置
 * 输入描述:
 * 第一行为 target，短字符串 (长度 <=100)
 * 第二行为 source，长字符串 (长度~= 500,000)
 * 输出描述
 * 最后一个子序列的起始位置， 即最后一个子序列首字母的下标
 * abc
 * abcaybec
 * @author yu.zh-neu
 * @create 2023-09-08 15:38
 */
public class IndexOfSubSequence {


    public static void sovle(String target, String source) {
        int index = source.length();
        for (int j = target.length() - 1; j >= 0; --j) {
            char ta = target.charAt(j);
            if (source.contains(String.valueOf(ta))) {
                int indexLast = source.lastIndexOf(String.valueOf(ta));
                if (index > indexLast) {
                    index = indexLast;
                } else {
                    System.out.println(-1);
                    return;
                }
            } else {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(index);
    }

    public static void main(String[] args) {
        try {
            Scanner s = new Scanner(System.in);
            String target = s.nextLine();// [0,100]
            String source = s.nextLine();// [0,50w]
            sovle(target, source);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("input error");
        }
    }
}

