package com.yz.leetcode;

/**
 * @author yu.zh-neu
 * @create 2023-11-24 9:57
 */
public class DeleteSameNum {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int num = removeDuplicates(nums);
        for (int i = 0; i < num; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 0;i < nums.length; i++) {
            if (nums[j] != nums[i]) {
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }
}
