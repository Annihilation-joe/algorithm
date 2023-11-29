package com.yz.exercise;

/**
 * @author yu.zh-neu
 * @create 2023-07-13 11:23
 */
public class NumSumToTarget {
    static int count = 0;
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        int i = coutSum(nums, target);
        System.out.println(i);

    }

    public static int coutSum(int[] nums, int target) {
        numSumDFS(nums, 0, target, 0);
        return count;
    }
    private static void numSumDFS(int[] nums, int sum, int target, int index) {
        if (index == nums.length) {
            if (sum == target) {
                count++;
            }
            return;
        }
        numSumDFS(nums, sum + nums[index], target, index + 1);
        numSumDFS(nums, sum - nums[index], target, index + 1);
    }
}
