package com.yz.leetcode;

import java.util.Arrays;

/**
 * @author yu.zh-neu
 * @create 2023-12-04 17:30
 */
public class CandyDivition {
    public static void main(String[] args) {
        int[] nums = {1,0,2};
        int candy = candy(nums);
        System.out.println(candy);
    }
    public static int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        int res = 0;
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i-1]) {
                left[i] = left[i - 1] + 1;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (i > 0 && ratings[i - 1] > ratings[i]) {
                right[i-1] = right[i] + 1;
            }
            res += Math.max(left[i], right[i]);
        }
        return res;
    }
}
