package com.yz.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 小明今年升学到了小学一年级来到新班级后，发现其他小朋友身高参差不产然后就想基于各小朋友和自己的身高差，对他们进行排序请帮他实现排序
 *
 * 输出排序结果，各正整数以空格分割和小明身高差绝对值最小的小朋友排在前面
 * 和小明身高差绝对值最大的小朋友排在后面
 * 如果两个小朋友和小明身高差一样
 * 则个子较小的小朋友排在前面
 *
 * @author yu.zh-neu
 * @create 2023-09-07 11:05
 */
public class HeightSort {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int h = s.nextInt();
        int n = s.nextInt();
        List<Integer> highs = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) {
            highs.add(s.nextInt());
        }
        highs.sort((h1, h2) -> {
            int diff1 = Math.abs(h1 - h);
            int diff2 = Math.abs(h2 - h);
            return diff1 == diff2 ? h1 - h2 : diff1 - diff2;
        });
        System.out.println(String.join(" ",
                highs.stream().map(Object::toString).toArray(String[]::new)));
        s.close();
    }
}

