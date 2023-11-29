package com.yz.leetcode;

/**
 * @author yu.zh-neu
 * @create 2023-11-23 15:28
 */
public class RemoveElementOfNum {
    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        int count = removeElement(nums, val);
        for (int i = 0; i < count; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }

        return j;
    }
}
