package com.yz.exercise;

/**
 * @author yu.zh-neu
 * @create 2023-07-07 18:19
 */
public class ArrayPartition {
    public static boolean canPartition(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % k != 0) {
            return false;
        }

        int target = sum / k;
        boolean[] visited = new boolean[nums.length];

        return backtrack(nums, k, target, 0, 0, visited);
    }

    private static boolean backtrack(int[] nums, int k, int target, int curSum, int start, boolean[] visited) {
        if (k == 1) {
            return true; // 已经找到k个和相等的子数组
        }

        if (curSum == target) {
            // 当前子数组的和等于目标和，递归查找下一个子数组
            return backtrack(nums, k - 1, target, 0, 0, visited);
        }

        for (int i = start; i < nums.length; i++) {
            if (!visited[i] && curSum + nums[i] <= target) {
                visited[i] = true;
                if (backtrack(nums, k, target, curSum + nums[i], i + 1, visited)) {
                    return true;
                }
                visited[i] = false;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        int k = 4;
        boolean canPartition = canPartition(nums, k);
        System.out.println("是否可以分解为" + k + "个和相等的子数组: " + canPartition);
    }
}

