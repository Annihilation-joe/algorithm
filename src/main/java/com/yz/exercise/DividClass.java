package com.yz.exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 分班
 * 幼儿园两个班的小朋友在排队时混在了一起，每位小朋友都知道自己是否与前面一位小朋友是否同班，请你帮忙把同班的小朋友找出来。小朋友的编号为整数，与前一位小朋友同班用Y 表示，不同班用 N 表示
 * 输入输出描述:
 * 输入描述:
 * 输入为空格分开的小朋友编号和是否同班标志。
 * 比如: 6/N 2/Y 3/N 4Y，表示共 4 位小朋友，2和6 同班，3和2不同班，4和3 同班其中，小朋友总数不超过 999，每个小朋友编号大于 0，小于等于 999不考虑输入格式错误问题。
 * 输出描述:
 * 输出为两行，每一行记录一个班小朋友的编号，编号用空格分开。且:
 * 1、编号需要按照大小升序排列Q，分班记录中第一个编号小的排在第一行
 * 2、若只有一个班的小朋友，第二行为空行。
 * 3、若输入不符合要求，则直接输出字符串 ERROR。
 *
 * 1/N 2/Y 3/N 4/Y
 * @author yu.zh-neu
 * @create 2023-09-08 15:52
 */
public class DividClass {

    public static void main(String[] args) {
        try {
            Scanner s = new Scanner(System.in);
            String[] lines = s.nextLine().split(" ");
            List<Integer> myListOne = new ArrayList<>();
            List<Integer> myListTwo = new ArrayList<>();
            // 0号1班 剩下2班
            int value = 1;
            for (int i = 0; i < lines.length; i++) {
                String[] num = lines[i].split("/");
                if (0 == i) {
                    myListOne.add(Integer.parseInt(num[0]));
                    value = 1;
                    continue;
                }
                if (value == 1) {
                    if ("Y".equals(num[1])) {
                        myListOne.add(Integer.parseInt(num[0]));
                    } else {
                        myListTwo.add(Integer.parseInt(num[0]));
                        value = 2;
                    }
                } else {// N
                    if ("Y".equals(num[1])) {
                        myListTwo.add(Integer.parseInt(num[0]));
                    } else {
                        myListOne.add(Integer.parseInt(num[0]));
                        value = 1;
                    }
                }
            }
            Collections.sort(myListOne);
            Collections.sort(myListTwo);
            for (int i = 0; i < myListOne.size(); ++i) {
                System.out.print(myListOne.get(i) + " ");
            }
            System.out.println();
            for (int i = 0; i < myListTwo.size(); ++i) {
                System.out.print(myListTwo.get(i) + " ");
            }
        } catch (Exception e) {

        }
    }
}

