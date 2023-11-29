package com.yz.od;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 题目
 * 在一个狭小的路口，每秒只能通过一辆车，假如车辆的颜色只有 3 种，找出 N 秒内经过的最多颜色的车辆数量
 * 二种颜色编号为 0,1,2
 * 输入
 * 第一行输入的是通过的车辆颜色信息
 * [0,1,1,2] 代表 4 秒钟通过的车辆颜色分别是 0,1,1,2第二行输入的是统计时间窗，整型，单位为秒
 * 输出
 * 输出指定时间窗内经过的最多颜色的车辆数量
 *
 * 测试结果
 * 0 1 2 1
 * 2
 * 1
 * @author yu.zh-neu
 * @create 2023-11-14 17:36
 */
public class MostColorOfCar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] colorStr = sc.nextLine().split("\\s+");
        int count = sc.nextInt();
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < colorStr.length; i++) {
            if (i >= count) {
                String key = colorStr[i - count];
                map.put(key, map.get(key) - 1);
            }
            int num = map.getOrDefault(colorStr[i], 0);
            map.put(colorStr[i], num + 1);
            if (num + 1 > max) {
                max = num + 1;
            }
        }
        System.out.println(max);
    }
}
