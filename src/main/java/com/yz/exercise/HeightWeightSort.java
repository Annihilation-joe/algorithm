package com.yz.exercise;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 某学校举行运动会,学生们按编号(1、2、3.....n) 进行标识现需要按照身高由低到高排列，对身高相同的人，按体重由轻到重排列，对于身高体重都相同的人，维持原有的编号顺序关系请输出排列后的学生编号
 * 输入
 * 两个序列，每个序列由 N 个正整数组成，( < n = 10)第一个序列中的数值代表身高，第二个序列中的数值代表体重
 * 输出
 * 排列结果，每个数据都是原始序列中的学生编号，编号从 1 开始
 * @author yu.zh-neu
 * @create 2023-09-08 15:00
 */
public class HeightWeightSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        String[] height = sc.nextLine().split(" ");
        String[] weight = sc.nextLine().split(" ");
        int[][] values = new int[N][3];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                values[i][0] = i + 1;
                values[i][1] = Integer.parseInt(height[i]);
                values[i][2] = Integer.parseInt(weight[i]);
            }
        }
        // 排序
        Arrays.sort(values, (v1, v2) -> v1[1]==v2[1]?v1[2]-v2[2]:v1[1]-v2[1]);
        for (int i = 0; i < N; i++) {
            System.out.print(values[i][0]);
            if (i != N - 1) {
                System.out.print(" ");
            }
        }
    }
}
