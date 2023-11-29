package com.yz.leetcode;

import java.util.Scanner;

/**
 * 给你一个下标从 0 开始的整数数组 nums 。请你从 nums 中找出和 最大 的一对数，且这两个数数位上最大的数字相等。
 *
 * 返回最大和，如果不存在满足题意的数字对，返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [51,71,17,24,42]
 * 输出：88
 * 解释：
 * i = 1 和 j = 2 ，nums[i] 和 nums[j] 数位上最大的数字相等，且这一对的总和 71 + 17 = 88 。
 * i = 3 和 j = 4 ，nums[i] 和 nums[j] 数位上最大的数字相等，且这一对的总和 24 + 42 = 66 。
 * 可以证明不存在其他数对满足数位上最大的数字相等，所以答案是 88 。
 * 示例 2：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：-1
 * 解释：不存在数对满足数位上最大的数字相等。
 * @author yu.zh-neu
 * @create 2023-11-17 11:17
 */
public class DoubleSumNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int l = s.indexOf("[");
        int r = s.indexOf("]");
        String str = s.substring(l + 1, r);
        String[] arr = str.split(",");
        int[] maxNum = new int[arr.length];
        int max = -1;
        for (int i = 0; i < arr.length; i++) {
            int num = Integer.parseInt(arr[i]);
            int ans = -1;
            while (num != 0) {
                ans = Math.max(ans, num % 10);
                num /= 10;
            }
            maxNum[i] = ans;
            if (i > 0) {
                for (int j = 0; j < i; j++) {
                    if (maxNum[j] == maxNum[i]) {
                        max = Math.max(max, Integer.parseInt(arr[i]) + Integer.parseInt(arr[j]));
                    }
                }
            }
        }
        System.out.println(max);
    }
}
