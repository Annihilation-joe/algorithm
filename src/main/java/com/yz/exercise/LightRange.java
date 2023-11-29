package com.yz.exercise;

import java.util.Scanner;

/**
 * 在一条笔直的公路上安装了 N 个路灯从位置 o开始安装，路灯之间间距固定为 1 米每个路灯都有自己的照明半径请计算第一个路灯和最后一个路灯之间无法照明的区间的长度和
 * 输入
 * 第一行为一个数N，表示路灯个数，1 <=  <= 100第二行为N 个空格分割的数，表示路灯的照明半径，1= 照明半径
 * 输出描述
 * 无法照明的区间的长度和
 * @author yu.zh-neu
 * @create 2023-09-08 14:54
 */
public class LightRange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int[] nums = new int[N];
        String[] strs = sc.nextLine().split(" ");
        for (int i = 0; i < strs.length; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max += nums[i] + nums[i+1] > 100 ? nums[i] + nums[i+1] - 100 : 0;
        }
        System.out.println(max);
    }
}
