package com.yz.od;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 华为OD机试: 相同数字的积木游戏 1
 * 题目
 * 小华和小薇一起通过玩积木游戏学习数学
 * 他们有很多积木，每个积木块上都有一个数字
 * 积木块上的数字可能相同。
 * 小华随机拿一些积木挨着排成一排，请小找到这排积木中数字相同目所外位置最远的 2 块积木块，计算他们的距离小薇请你帮忙替她解决这入问题。
 * 输入
 * 第一行输入为 N，表示小华排成一排的积木总数接下来 N 行每行一个数字，表示小花排成一排的积木上数字
 * 输出
 * 相同数字的积木的位置最远距离:
 * 如果所有积木数字都不相同，请返回 1
 *
 * @author yu.zh-neu
 * @create 2023-11-15 10:13
 */
public class DistanceOfSameblockn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(sc.nextLine());
        }
        int max = maxIndex(N, arr);
        System.out.println(max);
    }

    private static int maxIndex(int N, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        if (map.size() == N) {
            return -1;
        }
        final int[] max = {0};
        map.forEach((k, v) -> {
            if (v >= 2) {
                int low = 0;
                int heigh = N - 1;
                while (k != arr[low]) {
                    low ++;
                }
                while (k != arr[heigh]) {
                    heigh --;
                }
                max[0] = Math.max(max[0], heigh - low);
            }
        });
        return max[0];
    }
}
