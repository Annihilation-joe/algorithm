package com.yz.exercise;

import java.util.Arrays;
import java.util.Scanner;

/**
 * AB 两个人把苹果分为两堆，A 希望按照他的计算规则等分苹果他的计算规则是按照二级制加法计算，并且不计算进位 12+5=9(1100+0101=9),B 的计算规则是十进制加法,包括正常进位,B 希望在满足 A 的情况下获取苹果重量最多输入苹果的数量和每个苹果重量
 * 输出满足 A的情况下 B 获取的苹果总重量
 * 如果无法满足 A的要求输出-1
 * 数据范围:
 * 苹果数量 <= 200001 AW
 * 1 <= 每个苹果重量 <= 10000
 *
 * @author yu.zh-neu
 * @create 2023-09-07 11:40
 */
public class DividingApples {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        int x = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
            x ^= nums[i];
        }
        if (x == 0) {
            Arrays.sort(nums);
            int b = 0;
            for (int i = 1; i < n; i++) {
                b += nums[i];
            }
            System.out.println(b);
        } else {
            System.out.println(-1);
        }
    }
}


