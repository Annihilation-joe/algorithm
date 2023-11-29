package com.yz.exercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 题目
 * 为了充分发挥 GPU 算力
 * 需要尽可能多的将任务交给 GPU 执行
 * 现在有一个任务数组
 * 数组元素表示在这 1s 内新增的任务个数且每秒都有新增任务
 * 假设 GPU 最多一次执行 n 个任务次执行耗时 1s
 * 在保证 GPU 不空闲的情况下，最少需要多长时间执行完成
 * 输入
 * 第一个参数为 GPU 最多执行的任务个数取值范围 1 ~ 10000
 * 第二个参数为任务数组的长度取值范围 1 ~ 10000
 * 第三个参数为任务数组数字范围 1~ 10000
 * 输出
 * 执行完所有任务需要多少秒
 *
 * @author yu.zh-neu
 * @create 2023-09-08 12:04
 */
public class GPUCompute {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int len = s.nextInt();
        Integer[] jobs = new Integer[len];
        for (int i = 0; i < len; ++i) {
            jobs[i] = s.nextInt();
        }

        Arrays.sort(jobs, Comparator.reverseOrder());

        int time = 0;
        int more = 0;
        for (int i : jobs) {
            more = (i + more > n) ? i + more - n : 0;
            time++;
        }
        while (more > 0) {
            more -= n;
            time++;
        }

        System.out.print(time);
    }
}


