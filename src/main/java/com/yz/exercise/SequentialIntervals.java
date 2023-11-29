package com.yz.exercise;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 给定一个含有N 个正整数的数组，求出有多少个连续区间 (包括单个正整数)，它们的和大于等于x
 * 输入
 * 第一行两人整数N x ( < N <= 100000 , <= x <= 10000000第二行有 N 个正整数 (每个正整数小于等于 1 )
 * @author yu.zh-neu
 * @create 2023-09-07 15:30
 */
public class SequentialIntervals {


    public static int solution_01() {

        Scanner sc = new Scanner(System.in);
        String[] line1_list = sc.nextLine().split(" ");
        String[] line2_list = sc.nextLine().split(" ");

        int N = Integer.parseInt(line1_list[0]);
        int x = Integer.parseInt(line1_list[1]);
        int[] num_list = new int[line2_list.length];
        for (int i = 0; i < line2_list.length; i++) {
            num_list[i] = Integer.parseInt(line2_list[i]);
        }

        int[] sum = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i - 1] + num_list[i - 1];
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            int index = Arrays.binarySearch(sum, sum[i] + x);
            if (index < 0) {
                index = -(index + 1);
            }
            count += N - index + 1;
        }

        return count;
    }

    public static int solution_02 () {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();  // 数组长度
        int x = scanner.nextInt();  // 目标和
        int[] nums = new int[N];    // 存储正整数数组

        for (int i = 0; i < N; i++) {
            nums[i] = scanner.nextInt();
        }
        int count = 0; // 连续区间计数

        // 使用双指针技术求和
        int left = 0;
        int right = 0;
        int sum = 0;

        while (right < N) {
            sum += nums[right];

            while (sum >= x) {
                count += N - right;
                sum -= nums[left];
                left++;
            }

            right++;
        }
        return count;
    }

    public static void main(String[] args) {
//        int ans = solution_01();
        int ans = solution_02();
        System.out.println(ans);
    }
}


